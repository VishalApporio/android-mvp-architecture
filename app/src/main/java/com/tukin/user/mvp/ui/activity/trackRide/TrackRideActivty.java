package com.tukin.user.mvp.ui.activity.trackRide;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.model.GetDriverlocationResponse;
import com.tukin.user.mvp.data.network.model.trackRideDriverDetails.ViewDriverDetailsResponse;
import com.tukin.user.mvp.drawPath.drawroutemaps.DrawRouteMaps;
import com.tukin.user.mvp.drawPath.drawroutemaps.MapUtils;
import com.tukin.user.mvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackRideActivty extends BaseActivity implements TrackRideMvpView, OnMapReadyCallback {

    @Inject
    TrackRideMvpPresenter<TrackRideMvpView> mPresenter;

    GoogleMap mGoogleMap;
    String order_id;

    @BindView(R.id.drop_location_txt)
    TextView drop_location_txt;

    @BindView(R.id.driver_name_txt)
    TextView driver_name_txt;

    @BindView(R.id.status_txt)
    TextView status_txt;

    String str_phone_number;

    Marker mm, drop_marker, animated_marker;

    String order_status;
    int check = 0;


    public static String TAG = "TrackRideAactiviy";


    final Handler mHandeler = new Handler();
    Runnable mRunnable;
    public static boolean fetching_in_progress = false;
    ViewDriverDetailsResponse mViewDriverDetailsResponse;
    GetDriverlocationResponse mGetDriverlocationResponse;

    LatLng origin = null;
    LatLng destination = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_ride_activty);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(TrackRideActivty.this);

        bindView();
    }

    @Override
    protected void setUp() {

    }

    private void bindView() {

        order_id = getIntent().getStringExtra("order_id");
        Log.e("Order_id", order_id);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        callApiForGettingDriverDetails();
    }

    private void callApiForGettingDriverDetails() {

        mPresenter.viewDriverDetailsApi(order_id);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setMaxZoomPreference(18);
    }

    @Override
    public void getAllDriverDetailsResponse(ViewDriverDetailsResponse viewDriverDetailsResponse) {

        mViewDriverDetailsResponse = viewDriverDetailsResponse;

        order_status = mViewDriverDetailsResponse.getResponse().getOrderStatus().toString();

        Log.e("DriverDetails", "" + viewDriverDetailsResponse.getResponse().getBeginLat().toString());

        drop_location_txt.setText("" + viewDriverDetailsResponse.getResponse().getDropLocation().toString());
        driver_name_txt.setText("" + viewDriverDetailsResponse.getResponse().getDriverName().toString());

        if (viewDriverDetailsResponse.getResponse().getOrderStatus().equals("5")) {
            status_txt.setText("Driver Arrived");
        } else if (viewDriverDetailsResponse.getResponse().getOrderStatus().equals("6")) {
            status_txt.setText("Driver Arrived");
        }
        str_phone_number = viewDriverDetailsResponse.getResponse().getDriverPhone().toString();

        try {
            startRunnableProcess();
        } catch (Exception e) {
        }

    }

    @Override
    public void getDriverCurrentLocation(GetDriverlocationResponse getDriverlocationResponse) {

        mGetDriverlocationResponse = getDriverlocationResponse;
        Log.d("" + "Response", "---> specific driver api " + mGetDriverlocationResponse);

        try {
            if (mm == null) {
                origin = new LatLng(Double.parseDouble(mViewDriverDetailsResponse.getResponse().getDropLat()), Double.parseDouble(mViewDriverDetailsResponse.getResponse().getDropLong()));
                destination = new LatLng(Double.parseDouble(mGetDriverlocationResponse.getDetails().getCurrent_lat()), Double.parseDouble(mGetDriverlocationResponse.getDetails().getCurrent_long()));

                drawRoute(origin, destination, mGoogleMap);
            }

        } catch (Exception e) {
            Log.e("Exception", "" + e);
        }

        setDataAccordingToStatus(mGetDriverlocationResponse);
        fetching_in_progress = false;

    }

    public void startRunnableProcess() throws Exception {

        try {
            mRunnable = new Runnable() {
                @Override
                public void run() {

                    if (isConnectingToInternet(TrackRideActivty.this) && fetching_in_progress == false) {
                        try {
                            fetching_in_progress = true;

                            mPresenter.getCurrentDriverLocation(mViewDriverDetailsResponse.getResponse().getDriverId());


                        } catch (Exception e) {

                        }
                        mHandeler.postDelayed(mRunnable, 3000);
                    }
                }

            };
            runOnUiThread(mRunnable);
        } catch (Exception e) {

            Log.e("Exception", "" + e);
        }

    }

    public boolean isConnectingToInternet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void drawRoute(LatLng origin, LatLng destination, GoogleMap mMap) {
        mGoogleMap.clear();
        try {
            DrawRouteMaps.getInstance(this, this, null, false).draw(origin, destination, mMap);
        } catch (Exception e) {

        }


        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(origin)
                .include(destination).build();
        Point displaySize = new Point();
        getWindowManager().getDefaultDisplay().getSize(displaySize);

        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, displaySize.x, 500, 90));

        setMarker(mGetDriverlocationResponse);
    }

    public void setMarker(GetDriverlocationResponse response) {

        try {
            mm = MapUtils.setDrivermarker(this, mGoogleMap, new LatLng(Double.parseDouble(response.getDetails().getCurrent_lat()), Double.parseDouble(response.getDetails().getCurrent_long())), mViewDriverDetailsResponse.getResponse().getDriverName());

            if (mViewDriverDetailsResponse.getResponse().getOrderStatus().equals("3")) {
                MapUtils.setDestinationMarkerForPickPoint(this, mGoogleMap, origin, "Customer Location ");
            } else {
                drop_marker = MapUtils.setDestinationMarkerForDropPoint(this, mGoogleMap, origin, "Customer Location ");
            }

            //  animated_marker = MapUtils.setanimatedicon(destination, mGoogleMap, R.drawable.ic_arrow_back_black_24dp, "41e74c3c", "D0C0392B");

        } catch (Exception e) {
        }
    }

    private void setDataAccordingToStatus(GetDriverlocationResponse driverLocation) {
        try {
            switch (order_status) {
                case "1":
                    Log.d(TAG, "Ride accepted successfully");
                    break;
                case "2":
                    Log.d(TAG, "Ride Cancelled");
                    break;
                case "3":
                    Log.d(TAG, "Driver Arriving Now. ");
                    if (mm == null) {
//                    setMarker(driverLocation);
                        origin = new LatLng(Double.parseDouble(mViewDriverDetailsResponse.getResponse().getDropLat()), Double.parseDouble(mViewDriverDetailsResponse.getResponse().getDropLong()));
                        destination = new LatLng(Double.parseDouble(mGetDriverlocationResponse.getDetails().getCurrent_lat()), Double.parseDouble(mGetDriverlocationResponse.getDetails().getCurrent_long()));

                        drawRoute(origin, destination, mGoogleMap);
                    } else {
                        animateMarker(new LatLng(Double.parseDouble(driverLocation.getDetails().getCurrent_lat()), Double.parseDouble(driverLocation.getDetails().getCurrent_long())), Float.parseFloat("" + ""));
                    }
                    break;
                case "4":
                    Log.d(TAG, "Booking Failed. ");
                    break;
                case "5":
                    Log.d(TAG, "Ride Arrived on Door of Customer. ");
                    break;
                case "6":
                    Log.d(TAG, "Riding now, Customer is inside the car now.");

                    if (check == 0) {
                        mm = null;
                        check = 1;
                    }
                    if (mm == null) {
                        origin = new LatLng(Double.parseDouble(mViewDriverDetailsResponse.getResponse().getDropLat()), Double.parseDouble(mViewDriverDetailsResponse.getResponse().getDropLong()));
                        destination = new LatLng(Double.parseDouble(mGetDriverlocationResponse.getDetails().getCurrent_lat()), Double.parseDouble(mGetDriverlocationResponse.getDetails().getCurrent_long()));

                        drawRoute(origin, destination, mGoogleMap);
//                    setMarker(driverLocation);
                    } else {
                        animateMarker(new LatLng(Double.parseDouble(driverLocation.getDetails().getCurrent_lat()), Double.parseDouble(driverLocation.getDetails().getCurrent_long())), Float.parseFloat("" + ""));
                    }
                    break;
                case "7":
                    Log.d(TAG, "Ride Ended. ");
                    break;
                case "8":
                    Log.d(TAG, "Ride scheduled. ");
                    break;
                case "9":
                    Log.d(TAG, "Ride Cancelled.");
                    break;
            }
        } catch (Exception e) {

        }
        this.mGetDriverlocationResponse = driverLocation;
    }

    public void animateMarker(final LatLng toPosition, float bearingfactor) {

        Location startingLocation = new Location("starting point");
        startingLocation.setLatitude(mm.getPosition().latitude);
        startingLocation.setLongitude(mm.getPosition().longitude);
        Location endingLocation = new Location("ending point");
        endingLocation.setLatitude(toPosition.latitude);
        endingLocation.setLongitude(toPosition.longitude);
//        rotateMarker(mm,bearingfactor);

        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = mGoogleMap.getProjection();
        Point startPoint = proj.toScreenLocation(mm.getPosition());
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);
        final long duration = 1000;

        final Interpolator interpolator = new LinearInterpolator();

        handler.post(new Runnable() {
            @Override
            public void run() {

                try {
                    long elapsed = SystemClock.uptimeMillis() - start;
                    float t = interpolator.getInterpolation((float) elapsed / duration);
                    double lng = t * toPosition.longitude + (1 - t) * startLatLng.longitude;
                    double lat = t * toPosition.latitude + (1 - t)
                            * startLatLng.latitude;
                    mm.setPosition(new LatLng(lat, lng));

                    if (t < 1.0) {
                        // Post again 16ms later.
                        handler.postDelayed(this, 16);
                    } else {
                        if (false) {
                            mm.setVisible(false);
                        } else {
                            mm.setVisible(true);
                        }
                    }
                } catch (Exception e) {
                    Log.d("*****" + TAG, "Exception => " + e.getMessage());
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandeler.removeCallbacks(mRunnable);
    }
}

