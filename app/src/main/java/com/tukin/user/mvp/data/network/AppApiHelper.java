

package com.tukin.user.mvp.data.network;

import com.androidnetworking.common.Priority;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.tukin.user.mvp.data.db.model.CheckOutResponse;
import com.tukin.user.mvp.data.db.model.ViewCartResponse;
import com.tukin.user.mvp.data.db.model.orderHistory.OrderHistoryResponse;
import com.tukin.user.mvp.data.network.model.BlogResponse;
import com.tukin.user.mvp.data.network.model.GetDriverlocationResponse;
import com.tukin.user.mvp.data.network.model.GetLocationsModelClass;
import com.tukin.user.mvp.data.network.model.LoginRequest;
import com.tukin.user.mvp.data.network.model.LoginResponse;
import com.tukin.user.mvp.data.network.model.OpenSourceResponse;
import com.tukin.user.mvp.data.network.model.UpdateDeviceIdResponse;
import com.tukin.user.mvp.data.network.model.ViewResturanentsModel;
import com.tukin.user.mvp.data.network.model.productResponse.ViewProductResponse;
import com.tukin.user.mvp.data.network.model.trackRideDriverDetails.ViewDriverDetailsResponse;
import com.tukin.user.mvp.di.others.PlacePredictions;

import java.io.File;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by janisharali on 28/01/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                              request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                              request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doServerRegisterApiCall(LoginRequest.ServerRegisterRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_REGISTER)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<PlacePredictions> doAutoCompleteApiCall(String value, Double latitude, Double longitude, String google_key) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_AUTO_COMPLETE_API + value + "&location=" + latitude + "," + longitude + "&radius=1000&language=en&key=" + google_key)
                .build()
                .getObjectSingle(PlacePredictions.class);
    }

    @Override
    public Single<GetLocationsModelClass> doGetLocationApiCall(String place_id, String google_key) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_GET_LOCATION_API + place_id + "&key=" + google_key + "&language_code=en")
                .build()
                .getObjectSingle(GetLocationsModelClass.class);
    }

    //  https://maps.googleapis.com/maps/api/place/autocomplete/json?input=h&location=0.0,0.0&radius=1000&language=en&key=AIzaSyA0vZo1Wp9Jd_CIlwKC0bwZ8rbUDcMpe8A

    @Override
    public Single<LoginResponse> doViewProfileApiCall(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_VIEW_PROFILE)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<ViewDriverDetailsResponse> doViewAllDriverDetails(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_VIEW_DRIVER_DETAILS)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(ViewDriverDetailsResponse.class);
    }

    @Override
    public Single<GetDriverlocationResponse> doGetDriverCurrentLocation(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_GET_DRIVER_CURRENT_LOCATION)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(GetDriverlocationResponse.class);
    }


    @Override
    public Single<LoginResponse> doEditProfileApiCall(HashMap<String, String> bodyparameter, HashMap<String, File> images) {
        return Rx2AndroidNetworking.upload(ApiEndPoint.ENDPOINT_SERVER_EDIT_PROFILE)
                .addMultipartFile(images)
                .addMultipartParameter(bodyparameter)
                .setPriority(Priority.HIGH)
                .build()
                .getObjectSingle(LoginResponse.class);
    }


    @Override
    public Single<ViewResturanentsModel> doViewResturanentsApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_VIEW_RESTURANENTS)
                .build()
                .getObjectSingle(ViewResturanentsModel.class);
    }

    @Override
    public Single<UpdateDeviceIdResponse> doUpdateDeviceId(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_UPDATE_DEVICE_ID)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(UpdateDeviceIdResponse.class);
    }

    @Override
    public Single<OrderHistoryResponse> doViewAllOrderHistory(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_GET_VIEW_ORDER_HISTORY_API)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(OrderHistoryResponse.class);
    }

    @Override
    public Single<ViewProductResponse> doViewAllProductsApiCall(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_GET_VIEW_PRODUCTS_API)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(ViewProductResponse.class);
    }

    @Override
    public Single<CheckOutResponse> doServerCheckOut(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_CHECKOUT)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(CheckOutResponse.class);
    }

    @Override
    public Single<ViewCartResponse> doCallApiForViewCart(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_VIEW_CART)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(ViewCartResponse.class);
    }

    @Override
    public Single<CheckOutResponse> doCallApiForPlaceOrder(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_PLACE_ORDER)
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(CheckOutResponse.class);
    }

    @Override
    public Single<LoginResponse> doLogoutApiCall(HashMap<String, String> bodyparameter) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .addBodyParameter(bodyparameter)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(OpenSourceResponse.class);
    }
}

