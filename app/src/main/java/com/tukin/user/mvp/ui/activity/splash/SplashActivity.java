

package com.tukin.user.mvp.ui.activity.splash;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.tukin.user.R;
import com.tukin.user.mvp.location.LocationAddress;
import com.tukin.user.mvp.location.LocationManagerClass;
import com.tukin.user.mvp.location.LocationSession;
import com.tukin.user.mvp.service.SyncService;
import com.tukin.user.mvp.ui.activity.home.HomeActivity;
import com.tukin.user.mvp.ui.activity.login.LoginActivity;
import com.tukin.user.mvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by vishal@apporio.com on 05/03/18.
 */

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    @Inject
    LocationSession locationSession;

    Address addressFromLocation;

    @BindView(R.id.tv_location)
    TextView tv_location;

    private static final String TAG = "SplashActivity";
    private boolean is_gps_dialog_shown = false;
    private boolean is_internet_dialog_is_shown = false;
    String[] PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        checkPermissionsMethod();

    }

    private void checkPermissionsMethod() {

        if (!hasPermissions(this, PERMISSIONS)) {
            Log.e(TAG, "Checking Permission On Splash");

            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        } else {
            startGPSCheck();
        }
    }

    private void startGPSCheck() {
        Log.e(TAG, "Checking GPS status");
        if (!checkGPSisOnOrNot(SplashActivity.this)) {
            showGPSDialog();
        } else {
            Log.e(TAG, "Now GPS Status = " + true);
            startInternetCheckProcess();
        }
    }

    private void startInternetCheckProcess() {
        Log.i(TAG, "Now Checking net Connectivity");
        if (isNetworkConnected(this)) {
            Log.e(TAG, "Internet Connectivity Status " + true);
            try {
                mPresenter.onAttach(SplashActivity.this);
               // getLocation();
            } catch (Exception e) {
            }
        } else {
            Log.i(TAG, "Internet Connectivity Status " + false + ", Now Showing Internet Dialog");
            if (!is_internet_dialog_is_shown) {
                showInternetDialog();
            }
        }

    }

    private void fetchRemoteConfig() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();

            }
        }, 3000);
    }

    private void showInternetDialog() {
        new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                .setTextGravity(Gravity.CENTER)
                .setTitle("No Internet Connectivity!")
                .setMessage("It Seems You are out of Network, Please check you internet connection!")
                .addButton(SplashActivity.this.getString(R.string.retry), -1, -1, CFAlertDialog.CFAlertActionStyle.DEFAULT, CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        is_internet_dialog_is_shown = false;
                        startInternetCheckProcess();
                    }
                }).setCancelable(false).show();
        is_internet_dialog_is_shown = true;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (hasPermissions(SplashActivity.this, PERMISSIONS)) {
                    mPresenter.onAttach(SplashActivity.this);
                } else {
                    Log.i("" + TAG, "Some Permissions are missing");
                }
                return;
            }
        }
    }

    public void showGPSDialog() {
        if (!is_gps_dialog_shown) {
            Log.e(TAG, "Now GPS Status = " + false + ", Now Showing Dialog");
            new CFAlertDialog.Builder(this)
                    .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                    .setTitle(R.string.enable_app_location)
                    .setMessage("Please Enable your location to use the app services")
                    .addButton(SplashActivity.this.getString(R.string.open_location_settings), -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            SplashActivity.this.startActivity(myIntent);
                            dialogInterface.dismiss();
                            is_gps_dialog_shown = false;
                        }
                    }).setCancelable(false).show();
            is_gps_dialog_shown = true;
        }

    }


    public static boolean checkGPSisOnOrNot(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        if (!network_enabled && !gps_enabled) {
            return false;
        } else return true;
    }

    /**
     * Making the screen wait so that the  branding can be shown
     */
    @Override
    public void openLoginActivity() {

        fetchRemoteConfig();
    }

    @Override
    public void openMainActivity() {

        fetchRemoteConfig1();
    }

    private void fetchRemoteConfig1() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = HomeActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    @Override
    public void startSyncService() {
        SyncService.start(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    private void getLocation() {
        try {
            new LocationManagerClass(this, true).executeService(new LocationManagerClass.ApporioLocationListener() {
                @Override
                public void onLocationUpdate(Location location) {

                    try {
                        //  Toast.makeText(SplashActivity.this, "" + location.getLatitude() + location.getLongitude(), Toast.LENGTH_SHORT).show();

                        addressFromLocation = new LocationAddress().getAddressFromLocation(location.getLatitude(), location.getLongitude(), getApplicationContext());
                        // mPresenter.onAttach(SplashActivity.this);

                        Log.e("Address", "" + addressFromLocation);
                        Location location1 = new Location(LocationManager.GPS_PROVIDER);
                        location1.setLatitude(location.getLatitude());
                        location1.setLongitude(location.getLongitude());
                        locationSession.setLocationLatLong(location);
                        locationSession.setLocationAddress(addressFromLocation.getFeatureName());

                        tv_location.setText(addressFromLocation.getFeatureName());
                        locationSession.setFullLocationAddress(addressFromLocation.getFeatureName());
//                        mPresenter.callAuthenticationApi(androidId);

                    } catch (Exception e) {
                        Toast.makeText(SplashActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        } catch (Exception e) {
        }
    }
}
