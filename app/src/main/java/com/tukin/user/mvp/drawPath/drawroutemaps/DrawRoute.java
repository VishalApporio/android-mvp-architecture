package com.tukin.user.mvp.drawPath.drawroutemaps;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DrawRoute extends AsyncTask<String, Void, String> {

    private GoogleMap mMap;
    Context mContext ;
    Activity mActivity ;
    private static View mprogress_view ;
    private static boolean mshow_progress ;

    public DrawRoute(GoogleMap mMap , Context context , Activity activity , View view  , boolean showprogress) {
        this.mMap = mMap;
        this.mContext = context ;
        this.mActivity = activity ;
        mshow_progress = showprogress ;
        mprogress_view = view ;
    }

    @Override
    protected String doInBackground(String... url) {
        String data = "";
        try {
            data = getJsonRoutePoint(url[0]);
            Log.d("Background Task data", data);
        } catch (Exception e) {
            Log.d("Background Task", e.toString());
        }
        return data;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        RouteDrawerTask routeDrawerTask = new RouteDrawerTask(mMap , mContext , mActivity  , mprogress_view , mshow_progress );
        routeDrawerTask.execute(result);
    }

    /**
     * A method to download json data from url
     */
    private String getJsonRoutePoint(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("getJsonRoutePoint", data.toString());
            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

}
