package com.tukin.user.mvp.location;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by samirgoel3@gmail.com on 4/7/2017.
 */

public class LocationSession {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LocationPrefrences";
    public static String TAG = "LocationSession";


    public static final String KEY_CURRENT_LAT = "current_lat";
    public static final String KEY_CURRENT_LONG = "current_long";
    public static final String KEY_CURRENT_LOCATION_TEXT = "current_location_text";
    public static final String KEY_CURRENT_FULL_LOCATION_TEXT = "full_location_text";
    public static final String KEY_LOCATION_SERVICE_STARTED = "location_service_started";
    public static final String KEY_ORDER_WHEN = "order_when";
    public static final String KEY_SCHEDULE_DATE = "schedule_date";
    public static final String KEY_SCHEDULE_TIME = "schedule_time";
    public static final String KEY_ACCURACY = "accuracy";

    public boolean isLocationserviceStarted() {
        return pref.getBoolean(KEY_LOCATION_SERVICE_STARTED, false);
    }


    public LocationSession(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLocationLatLong(Location location) {
        editor.putString(KEY_CURRENT_LAT, "" + location.getLatitude());
        editor.putString(KEY_CURRENT_LONG, "" + location.getLongitude());
        editor.putString(KEY_ACCURACY, "" + location.getAccuracy());

        Log.d("" + TAG, "Recent updated in session lat:" + location.getLatitude() + " longitude:" + location.getLongitude() + "   Accuracy:" + location.getAccuracy());
        editor.commit();
    }


    public void setLocationAddress(String current_location_txt) {
        editor.putString(KEY_CURRENT_LOCATION_TEXT, current_location_txt);
        editor.commit();

        Log.e("Current_location", "" + current_location_txt);
    }

    public void setFullLocationAddress(String full_location_text) {
        editor.putString(KEY_CURRENT_FULL_LOCATION_TEXT, full_location_text);
        editor.commit();

        Log.e("full_location_text", "" + full_location_text);
    }


    public HashMap<String, String> getLocationDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_CURRENT_LAT, pref.getString(KEY_CURRENT_LAT, ""));
        user.put(KEY_CURRENT_LONG, pref.getString(KEY_CURRENT_LONG, ""));
        user.put(KEY_CURRENT_LOCATION_TEXT, pref.getString(KEY_CURRENT_LOCATION_TEXT, "Not yet fetched"));
        user.put(KEY_CURRENT_FULL_LOCATION_TEXT, pref.getString(KEY_CURRENT_FULL_LOCATION_TEXT, "Not yet fetched"));
        return user;
    }

    public void setOrderWhen(String type) {
        editor.putString(KEY_ORDER_WHEN, type);
        editor.commit();
        Log.e("Order_when_type", "" + type);

    }

    public HashMap<String, String> getOrderWhen() {
        HashMap<String, String> user1 = new HashMap<>();
        user1.put(KEY_ORDER_WHEN, pref.getString(KEY_ORDER_WHEN, "ASAP"));

        return user1;
    }

    public void setScheduleTIme(String schedule_date, String schedule_time) {
        editor.putString(KEY_SCHEDULE_DATE, schedule_date);
        editor.putString(KEY_SCHEDULE_TIME, schedule_time);
        editor.commit();

    }

    public HashMap<String, String> getScheduleTime() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_SCHEDULE_DATE, pref.getString(KEY_SCHEDULE_DATE, ""));
        user.put(KEY_SCHEDULE_TIME, pref.getString(KEY_SCHEDULE_TIME, ""));

        return user;
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
    }

}
