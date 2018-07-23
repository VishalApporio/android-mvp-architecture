

package com.tukin.user.mvp.data.network;


import com.tukin.user.BuildConfig;

/**
 * Created by amitshekhar on 01/02/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_SERVER_REGISTER = BuildConfig.BASE_URL + "signup_user";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL + "login";

    public static final String ENDPOINT_SERVER_VIEW_PROFILE = BuildConfig.BASE_URL + "view_profile";

    public static final String ENDPOINT_SERVER_EDIT_PROFILE = BuildConfig.BASE_URL + "edit_profile";

    public static final String ENDPOINT_SERVER_VIEW_RESTURANENTS = BuildConfig.BASE_URL + "Home_page";

    public static final String ENDPOINT_SERVER_VIEW_DRIVER_DETAILS = BuildConfig.BASE_URL + "View_ride_info_driver";

    public static final String ENDPOINT_SERVER_UPDATE_DEVICE_ID = BuildConfig.BASE_URL + "User_did_update";

    public static final String ENDPOINT_SERVER_GET_DRIVER_CURRENT_LOCATION = BuildConfig.BASE_URL + "view_driver_profile";

    public static final String ENDPOINT_SERVER_AUTO_COMPLETE_API = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=";

    public static final String ENDPOINT_SERVER_GET_LOCATION_API = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";

    public static final String ENDPOINT_SERVER_GET_VIEW_PRODUCTS_API = BuildConfig.BASE_URL + "Category_data";

    public static final String ENDPOINT_SERVER_GET_VIEW_ORDER_HISTORY_API = BuildConfig.BASE_URL + "Order_history";

    public static final String ENDPOINT_SERVER_CHECKOUT = BuildConfig.BASE_URL + "Add_cart";

    public static final String ENDPOINT_SERVER_VIEW_CART = BuildConfig.BASE_URL + "View_cart";

    public static final String ENDPOINT_SERVER_PLACE_ORDER = BuildConfig.BASE_URL + "Place_order";


    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "user_logout";

    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL
            + "/5926ce9d11000096006ccb30";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL
            + "/5926c34212000035026871cd";

    public static final String ENDPOINT_FOR_IMAGE = "http://apporio.org/Tukin/";


    public static final String LOGIN = "";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
