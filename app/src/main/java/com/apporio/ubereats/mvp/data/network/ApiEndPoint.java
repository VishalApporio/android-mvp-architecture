

package com.apporio.ubereats.mvp.data.network;


import com.apporio.ubereats.BuildConfig;

/**
 * Created by amitshekhar on 01/02/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_SERVER_LOGIN = "http://ubereatsmocks.apporioinfolabs.mockable.io/uber_eats_login";

    public static final String ENDPOINT_SERVER_VIEW_PROFILE = "http://ubereatsmocks.apporioinfolabs.mockable.io/uber_eats_register";

    public static final String ENDPOINT_SERVER_VIEW_RESTURANENTS = "http://ubereatsmocks.apporioinfolabs.mockable.io/home_screen";

    public static final String ENDPOINT_SERVER_AUTO_COMPLETE_API = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=";

    public static final String ENDPOINT_SERVER_GET_LOCATION_API = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";

    public static final String ENDPOINT_SERVER_GET_VIEW_PRODUCTS_API = "http://ubereatsmocks.apporioinfolabs.mockable.io/specific_restaurent_products";


    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/588d161c100000a9072d2946";

    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL
            + "/5926ce9d11000096006ccb30";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL
            + "/5926c34212000035026871cd";


    public static final String LOGIN = "";
    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
