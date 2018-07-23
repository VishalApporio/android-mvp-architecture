package com.tukin.user.mvp.drawPath.drawroutemaps;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Criteria;
import android.location.Location;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.model.GetDriverlocationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapUtils {
    static Marker marker;
    public static PolylineOptions lineOptions = null;
    public static Marker customMarker;


    private static List<String> markers_id = new ArrayList<>();
    private static List<String> cloner = new ArrayList<>();
    private static List<String> latest_id = new ArrayList<>();
    private static List<String> old_id = new ArrayList<>();
    private static HashMap<String, GetDriverlocationResponse.DetailsBean> data = new HashMap<>();
    private static Float f = 0.0f;

    @SuppressLint("LongLogTag")
    public static void animateMarker(String driver_id, final LatLng toPosition, final boolean hideMarke, GoogleMap googleMap, final Marker m, float bearingfactor) {

        Log.d("##****animateMarker with driver_id = ", "" + driver_id);
        Location startingLocation = new Location("starting point");
        startingLocation.setLatitude(marker.getPosition().latitude);
        startingLocation.setLongitude(marker.getPosition().longitude);
        Location endingLocation = new Location("ending point");
        endingLocation.setLatitude(toPosition.latitude);
        endingLocation.setLongitude(toPosition.longitude);
        float targetBearing = startingLocation.bearingTo(endingLocation);


        Log.d("*** Target Bearnign ", "" + targetBearing);
        rotateMarker(m, bearingfactor, googleMap);


        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = googleMap.getProjection();
        Point startPoint = proj.toScreenLocation(m.getPosition());
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
                    m.setPosition(new LatLng(lat, lng));

                    if (t < 1.0) {
                        // Post again 16ms later.
                        handler.postDelayed(this, 16);
                    } else {
                        if (hideMarke) {
                            m.setVisible(false);
                        } else {
                            m.setVisible(true);
                        }
                    }
                } catch (Exception e) {

                }
            }
        });
    }

    public static void setMapTheme(Context context, GoogleMap googlemap) {

        try {
            googlemap.setBuildingsEnabled(false);
//            googlemap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.uber_theme));
        } catch (Resources.NotFoundException e) {
            Log.e("Main Activity", "Can't find style. Error: ", e);
        }
//        try {
//            // Customise the styling of the base map using a JSON object defined
//            // in a raw resource file.
//            boolean success = googlemap.setMapStyle(
//                    MapStyleOptions.loadRawResourceStyle(
//                            context, R.raw.style_uber));
//
//            if (!success) {
//                Log.e("MapsActivityRaw", "Style parsing failed.");
//            }
//        } catch (Resources.NotFoundException e) {
//            Log.e("MapsActivityRaw", "Can't find style.", e);
//        }
    }


    public static class Markerbank {

        static List<String> driver_id_data = new ArrayList<>();
        static List<Marker> markers_data = new ArrayList<>();

        public static void clearMarkerBank() {
            driver_id_data.clear();
            markers_data.clear();
        }


        public static Marker getMarker(String driverid) {
            if (driver_id_data.contains(driverid)) {
                return markers_data.get(driver_id_data.indexOf(driverid));
            } else {
                return null;
            }
        }


        public static void addmarkerToBank(String driver_id, Marker marker) {
            driver_id_data.add(driver_id);
            markers_data.add(marker);
        }

    }


    public static void removeMarker(String driver_id, GoogleMap map) {
        try {
            marker = Markerbank.getMarker(driver_id);
            if (marker != null) {
                marker.setVisible(false);
            }
        } catch (Exception e) {

        }
    }

    public static void removeMarker(String driver_id) {
        try {
            marker = Markerbank.getMarker(driver_id);
            if (marker != null) {
                marker.setVisible(false);
            }
        } catch (Exception e) {

        }
    }


    public static void removeAllMarkers() {
        for (int i = 0; i < Markerbank.driver_id_data.size(); i++) {
            removeMarker(Markerbank.driver_id_data.get(i));
        }
    }


    public static void removeAllMarkersThatNotSatisfiesCondition(LatLng pinnedlocation) {

        for (int i = 0; i < Markerbank.driver_id_data.size(); i++) {
            if (AerialDistance.aerialDistanceFunctionInMeters(pinnedlocation.latitude, pinnedlocation.longitude, Markerbank.getMarker(Markerbank.driver_id_data.get(i)).getPosition().latitude, Markerbank.getMarker(Markerbank.driver_id_data.get(i)).getPosition().longitude) > 3000) {
                removeMarker(Markerbank.driver_id_data.get(i));
            }
        }

    }

    public static void removeAllMarkersThatSatisfiesCondition(LatLng pinnedlocation) {

        for (int i = 0; i < Markerbank.driver_id_data.size(); i++) {
            removeMarker(Markerbank.driver_id_data.get(i));
        }

    }


    ///  for main activity

    public static void slideiewToBottom(View view) {
        view.animate().translationY(view.getHeight()).alpha(1.0f);

    }


    static public void rotateMarker(final Marker marker, final float toRotation, GoogleMap map) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final float startRotation = marker.getRotation();
        final long duration = 1000;

        final Interpolator interpolator = new LinearInterpolator();


        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed / duration);

                float rot = t * toRotation + (1 - t) * startRotation;

                marker.setRotation(-rot > 180 ? rot / 2 : rot);
                if (t < 1.0) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                }
            }
        });
    }


    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        float dist = (float) (earthRadius * c);

        return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


    public static Marker setNormalmarker(GoogleMap googlemap, LatLng lat_long, int marker_image) {
        MarkerOptions marker_option = new MarkerOptions().position(lat_long).icon(BitmapDescriptorFactory.fromResource(marker_image));
        Marker mm = googlemap.addMarker(marker_option);
        return mm;
    }

    public static Marker setDestinationMarkerForPickPoint(Context context, GoogleMap mMap, LatLng markerLatLng, String location_text) {
        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.destination_marker, null);

        Marker customMarker = mMap.addMarker(new MarkerOptions()
                .position(markerLatLng)
                .title("Title")
                .snippet("Description")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(context, marker))));
        return customMarker;

    }

    public static Marker setDestinationMarkerForDropPoint(Context context, GoogleMap mMap, LatLng markerLatLng, String location_text) {
        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.red_destination_marker, null);

        Marker customMarker = mMap.addMarker(new MarkerOptions()
                .position(markerLatLng)
                .title("Title")
                .snippet("Description")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(context, marker))));
        return customMarker;

    }


    public static Marker setDrivermarker(Context context, GoogleMap mMap, LatLng markerLatLng, String driver_name) {
        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.car_marker, null);
        TextView driver_name_txt = (TextView) marker.findViewById(R.id.driver_name_txt);
        driver_name_txt.setText("" + driver_name);

        if (null != customMarker) {
            customMarker.remove();
        }

        customMarker = mMap.addMarker(new MarkerOptions()
                .position(markerLatLng)
                .title("Title")
                .snippet("Description")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(context, marker))));
        return customMarker;

    }

    public static void setGreedmarker(Context context, GoogleMap mMap, LatLng marlerlatlong) {
        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.green_marker, null);


        Marker customMarker = mMap.addMarker(new MarkerOptions()
                .position(marlerlatlong)
                .title("Title")
                .snippet("Description")
                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(context, marker))));

    }


    public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }


    public static LatLng getCenterOfTwoLocations(double lat1, double lon1, double lat2, double lon2) {

        double dLon = Math.toRadians(lon2 - lon1);

        //convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        lon1 = Math.toRadians(lon1);

        double Bx = Math.cos(lat2) * Math.cos(dLon);
        double By = Math.cos(lat2) * Math.sin(dLon);
        double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
        double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);

        //print out in degrees
        System.out.println(Math.toDegrees(lat3) + " " + Math.toDegrees(lon3));


        return new LatLng(Math.toDegrees(lat3), Math.toDegrees(lon3));

    }


    public static Marker setanimatedicon(LatLng current_latlong, GoogleMap mMap, int ico_image, String fill_color, String stroke_color) {
        Marker currLocationMarker;
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(current_latlong);
        markerOptions.title("Current Position");
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(ico_image));
        currLocationMarker = mMap.addMarker(markerOptions);

        float stroke_Width = (float) 2;
        Circle circle2 = mMap.addCircle(new CircleOptions()
                        .center(new LatLng(current_latlong.latitude, current_latlong.longitude))
                        .radius(30)
                        .fillColor(Color.parseColor("#" + fill_color))
                        .strokeColor(Color.parseColor("#" + stroke_color))
                        .strokeWidth(stroke_Width)
                // .strokeColor(Color.parseColor("#3498db"))
                //     .strokeWidth(stroke_Width)
        );
        circle2.setCenter(current_latlong);


        final Circle circle = mMap.addCircle(new CircleOptions().center(current_latlong)
                .strokeColor(Color.parseColor("#3498db")).radius(300).strokeWidth(stroke_Width));

        ValueAnimator vAnimator = new ValueAnimator();
        vAnimator.setRepeatCount(ValueAnimator.INFINITE);
        vAnimator.setRepeatMode(ValueAnimator.RESTART);  /* PULSE */
        vAnimator.setIntValues(0, 100);
        vAnimator.setDuration(2000);
        vAnimator.setEvaluator(new IntEvaluator());
        vAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        vAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                // Log.e("", "" + animatedFraction);
                circle.setRadius(animatedFraction * 350);
            }
        });
        vAnimator.start();
        return currLocationMarker;
    }


    public static String getDirectionsUrl(LatLng origin, LatLng dest, Context context) {
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        String sensor = "sensor=false";
        String key = "key=" + context.getResources().getString(R.string.google_map_key);
        String parameters = str_origin + "&" + str_dest + "&" + sensor + "&" + key;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;
        return url;
    }

    public static String getDistancematrixUrl(LatLng source, LatLng destination, Context context) {
        return "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + source.latitude + "," + source.longitude + "&destinations=" + destination.latitude + "," + destination.longitude + "&language=en-EN&key=" + context.getResources().getString(R.string.google_map_key);
    }


    public static String getStaticMapImageUrl(String latitude, String longitude, Context context) {
        return "https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=15&size=1000x1000&key=" + context.getResources().getString(R.string.google_map_key);
    }

    ///////////////pulsating marker
    public static Circle lastUserCircle;
    public static long pulseDuration = 1000;
    public static ValueAnimator lastPulseAnimator;

    public static void addPulsatingEffect(final LatLng userLatlng, final GoogleMap googlemap, final Context context) {
        if (lastPulseAnimator != null) {
            lastPulseAnimator.cancel();
            Log.d("onLocationUpdated: ", "cancelled");
        }
        if (lastUserCircle != null)
            lastUserCircle.setCenter(userLatlng);
        Criteria userLocation = null;
        lastPulseAnimator = valueAnimate(userLocation.getAccuracy(), pulseDuration, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (lastUserCircle != null)
                    lastUserCircle.setRadius((Float) animation.getAnimatedValue());

                else {
                    lastUserCircle = googlemap.addCircle(new CircleOptions()
                            .center(userLatlng)
                            .radius((Float) animation.getAnimatedValue())
                            .strokeColor(Color.RED)
                            .fillColor(Color.parseColor(String.valueOf(context.getResources().getColor(R.color.colorPrimary)))));
                }
            }
        });

    }

    protected static ValueAnimator valueAnimate(float accuracy, long duration, ValueAnimator.AnimatorUpdateListener updateListener) {
        Log.d("valueAnimate: ", "called");
        ValueAnimator va = ValueAnimator.ofFloat(0, accuracy);
        va.setDuration(duration);
        va.addUpdateListener(updateListener);
        va.setRepeatCount(ValueAnimator.INFINITE);
        va.setRepeatMode(ValueAnimator.RESTART);

        va.start();
        return va;
    }


/////////////////////////// track ride activity utils


    public static void setbounds(LatLng origin, LatLng destination, GoogleMap mMap, Activity activity) {
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(origin)
                .include(destination).build();
        Point displaySize = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(displaySize);
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, displaySize.x, 500, 30));
    }


}
