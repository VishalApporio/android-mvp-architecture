package com.tukin.user.mvp.drawPath.drawroutemaps;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ocittwo on 11/14/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class DrawRouteMaps {

    private static DrawRouteMaps instance;
    private static Activity mActivity;
    private Context context;
    private static View mprogress_view ;
    private static boolean mshow_progress ;

    public static DrawRouteMaps getInstance(Context context , Activity activity , View view  , boolean showprogress) {
        instance = new DrawRouteMaps();
        instance.context = context;
        mActivity = activity ;
        mshow_progress = showprogress ;
        mprogress_view = view ;
        return instance;
    }

    public DrawRouteMaps draw(LatLng origin, LatLng destination, GoogleMap googleMap ){
        String url_route = MapUtils.getDirectionsUrl(origin , destination , context);
        DrawRoute drawRoute = new DrawRoute(googleMap , context , mActivity  , mprogress_view , mshow_progress);
        drawRoute.execute(url_route);
        return instance;
    }

    public static Context getContext() {
        return instance.context;
    }
}
