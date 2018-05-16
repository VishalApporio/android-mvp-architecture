

package com.apporio.ubereats.mvp.data.network;

import com.apporio.ubereats.mvp.data.network.model.BlogResponse;
import com.apporio.ubereats.mvp.data.network.model.GetLocationsModelClass;
import com.apporio.ubereats.mvp.data.network.model.LoginRequest;
import com.apporio.ubereats.mvp.data.network.model.LoginResponse;
import com.apporio.ubereats.mvp.data.network.model.LogoutResponse;
import com.apporio.ubereats.mvp.data.network.model.OpenSourceResponse;
import com.apporio.ubereats.mvp.data.network.model.ViewResturanentsModel;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.AllProductResponse;
import com.apporio.ubereats.mvp.di.others.PlacePredictions;

import io.reactivex.Single;

/**
 * Created by vishal@apporio.com on 27/01/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LoginResponse> doServerRegisterApiCall(LoginRequest.ServerRegisterRequest request);

    Single<LoginResponse> doViewProfileApiCall();

    Single<AllProductResponse> doViewAllProductsApiCall();

    Single<ViewResturanentsModel> doViewResturanentsApiCall();

    Single<PlacePredictions> doAutoCompleteApiCall(String value,Double latitude, Double longitude, String google_key);

    Single<GetLocationsModelClass> doGetLocationApiCall(String place_id, String google_key);

    Single<LogoutResponse> doLogoutApiCall();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
