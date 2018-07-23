

package com.tukin.user.mvp.data.network;

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

import io.reactivex.Single;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LoginResponse> doServerRegisterApiCall(LoginRequest.ServerRegisterRequest request);

    Single<LoginResponse> doViewProfileApiCall(HashMap<String, String> bodyparameter);

    Single<ViewDriverDetailsResponse> doViewAllDriverDetails(HashMap<String, String> bodyparameter);

    Single<GetDriverlocationResponse> doGetDriverCurrentLocation(HashMap<String, String> bodyparameter);

    Single<LoginResponse> doEditProfileApiCall(HashMap<String, String> bodyparameter,HashMap<String ,File> images);

    Single<CheckOutResponse> doServerCheckOut(HashMap<String, String> bodyparameter);

    Single<ViewProductResponse> doViewAllProductsApiCall(HashMap<String, String> bodyparameter);

    Single<ViewResturanentsModel> doViewResturanentsApiCall();

    Single<UpdateDeviceIdResponse> doUpdateDeviceId(HashMap<String, String> bodyparameter);

    Single<OrderHistoryResponse> doViewAllOrderHistory(HashMap<String, String> bodyparameter);

    Single<PlacePredictions> doAutoCompleteApiCall(String value,Double latitude, Double longitude, String google_key);

    Single<GetLocationsModelClass> doGetLocationApiCall(String place_id, String google_key);

    Single<ViewCartResponse> doCallApiForViewCart(HashMap<String, String> bodyparameter);

    Single<CheckOutResponse> doCallApiForPlaceOrder(HashMap<String, String> bodyparameter);


    Single<LoginResponse> doLogoutApiCall(HashMap<String, String> bodyparameter);

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
