package com.apporio.ubereats.mvp.ui.activity.deliveryLocation;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.GetLocationsModelClass;
import com.apporio.ubereats.mvp.di.others.AutoCompleteAdapter;
import com.apporio.ubereats.mvp.di.others.PlaceAutoComplete;
import com.apporio.ubereats.mvp.di.others.PlacePredictions;
import com.apporio.ubereats.mvp.location.LocationManagerClass;
import com.apporio.ubereats.mvp.location.LocationSession;
import com.apporio.ubereats.mvp.ui.base.BaseActivity;
import com.mindorks.placeholderview.annotations.Click;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeliveryLocationActivity extends BaseActivity implements DeliveryLocationMvpView {

    @Inject
    DeliveryLocationMvpPresenter<DeliveryLocationMvpView> mPresenter;

    @Inject
    LocationSession locationSession;

    private EditText editText_address;
    private Handler handler;
    double latitude;
    double longitude;
    private PlacePredictions predictions;
    private ListView mAutoCompleteList;
    private AutoCompleteAdapter mAutoCompleteAdapter;
    ImageView iv_search;
    ProgressBar progressBar;
    private TextView tv_toolbar_text;
    LinearLayout ll_list;
    String place_id, place_location;
    ArrayList<PlaceAutoComplete> getPlaces11;
    Boolean check = false;
    GetLocationsModelClass mGetLocationModelClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_location);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(DeliveryLocationActivity.this);

        initialization();
        setUp();


        Toolbar toolbar = (Toolbar) findViewById(R.id.enter_pickup);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        ll_list = (LinearLayout) findViewById(R.id.ll_list);

        getLocation();
    }

    private void initialization() {

        tv_toolbar_text = (TextView) findViewById(R.id.tv_toolbar_text);
        tv_toolbar_text.setText("Delivery Location");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        iv_search = (ImageView) findViewById(R.id.iv_search);
        mAutoCompleteList = (ListView) findViewById(R.id.searchResultLV);
        editText_address = (EditText) findViewById(R.id.adressText);

        editTextWatcher();

    }

    private void editTextWatcher() {

        editText_address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                Log.e("******************", "" + check);


                if (check == true) {
                    check = false;
                } else {

                    progressBar.setVisibility(View.VISIBLE);
                    iv_search.setVisibility(View.GONE);

                    Runnable run = new Runnable() {
                        @Override
                        public void run() {

                            Log.e("Latitude", "" + latitude);
                            Log.e("Longitude", "" + latitude);
                            Log.e("value", "" + editText_address.getText().toString());
                            Log.e("GoogleKey", "" + getResources().getString(R.string.google_map_key));
                            mPresenter.onViewAutoCompleteAddress(editText_address.getText().toString(), latitude, longitude, getResources().getString(R.string.google_map_key));
                        }

                    };

                    // only canceling the network calls will not help, you need to remove all callbacks as well
                    // otherwise the pending callbacks and messages will again invoke the handler and will send the request
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    } else {
                        handler = new Handler();
                    }
                    handler.postDelayed(run, 100);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }

    @Override
    protected void setUp() {

        onCLickListItem();
    }

    public void getLocation() {

        new LocationManagerClass(DeliveryLocationActivity.this, true).executeService(new LocationManagerClass.ApporioLocationListener() {
            @Override
            public void onLocationUpdate(Location location) {

                latitude = location.getLatitude();
                longitude = location.getLongitude();

                Log.e("Latitude", "" + latitude);
                Log.e("longitude", "" + longitude);


            }
        });

    }

    @Override
    public void onViewAfterCallingAPi() {
        progressBar.setVisibility(View.GONE);
        ll_list.setVisibility(View.VISIBLE);
    }

    @Override
    public void onViewAfterListIsEmty() {
        ll_list.setVisibility(View.GONE);
    }

    @Override
    public void onViewAfterListisNotEmpty() {
        iv_search.setVisibility(View.VISIBLE);
    }

    @Override
    public void onViewErrorOcurred() {
        ll_list.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        iv_search.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCLickListItem() {

        mAutoCompleteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                check = true;
                place_id = getPlaces11.get(position).getPlaceID();
                place_location = getPlaces11.get(position).getPlaceDesc();

                Log.e("place_id", "" + place_id);
                Log.e("place_desc", "" + place_location);

                editText_address.setText(place_location);

                locationSession.setFullLocationAddress(place_location);


                mPresenter.getAddressFromApi(place_id, getResources().getString(R.string.google_map_key));

                ll_list.setVisibility(View.GONE);

            }
        });

    }

    @Override
    public void getPlaces(ArrayList<PlaceAutoComplete> getPlaces) {
        if (mAutoCompleteAdapter == null) {
            mAutoCompleteAdapter = new AutoCompleteAdapter(this, getPlaces, DeliveryLocationActivity.this);
            mAutoCompleteList.setAdapter(mAutoCompleteAdapter);

            Log.e("Places", "" + getPlaces);
            getPlaces11 = getPlaces;

        } else {
            mAutoCompleteAdapter.clear();
            mAutoCompleteAdapter.addAll(getPlaces);
            mAutoCompleteAdapter.notifyDataSetChanged();
            mAutoCompleteList.invalidate();

        }
    }

    @Override
    public void getSelectedLocation(GetLocationsModelClass getLocationsModelClass) {

        mGetLocationModelClass = getLocationsModelClass;

    }

    @OnClick(R.id.btn_submit)
    void onClickForSubmitLocation(){

        if(!editText_address.getText().toString().equals("")){
            Log.e("******8Location",""+mGetLocationModelClass.getResult().getGeometry().getLocation().getLat());

            Location location = new Location(LocationManager.GPS_PROVIDER);
            location.setLatitude(mGetLocationModelClass.getResult().getGeometry().getLocation().getLat());
            location.setLongitude(mGetLocationModelClass.getResult().getGeometry().getLocation().getLng());
            locationSession.setLocationLatLong(location);
            locationSession.setLocationAddress(mGetLocationModelClass.getResult().getName().toLowerCase().trim());
            finish();
        }else {
            showMessage("Please enter your location");
        }



    }


}
