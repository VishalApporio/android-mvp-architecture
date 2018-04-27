/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.apporio.ubereats.mvp.data.network;

import com.apporio.ubereats.mvp.data.network.model.BlogResponse;
import com.apporio.ubereats.mvp.data.network.model.GetLocationsModelClass;
import com.apporio.ubereats.mvp.data.network.model.LogoutResponse;
import com.apporio.ubereats.mvp.data.network.model.OpenSourceResponse;
import com.apporio.ubereats.mvp.data.network.model.LoginRequest;
import com.apporio.ubereats.mvp.data.network.model.LoginResponse;
import com.apporio.ubereats.mvp.data.network.model.ViewResturanentsModel;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.AllProductResponse;
import com.apporio.ubereats.mvp.di.others.PlacePredictions;
import com.rx2androidnetworking.Rx2AndroidNetworking;

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
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<PlacePredictions> doAutoCompleteApiCall(String value, Double latitude, Double longitude,String google_key) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_AUTO_COMPLETE_API+value+"&location="+latitude+","+longitude+"&radius=1000&language=en&key="+google_key)
                .build()
                .getObjectSingle(PlacePredictions.class);
    }

    @Override
    public Single<GetLocationsModelClass> doGetLocationApiCall(String place_id, String google_key) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_GET_LOCATION_API+place_id+"&key="+google_key+"&language_code=en")
                .build()
                .getObjectSingle(GetLocationsModelClass.class);
    }
    //  https://maps.googleapis.com/maps/api/place/autocomplete/json?input=h&location=0.0,0.0&radius=1000&language=en&key=AIzaSyA0vZo1Wp9Jd_CIlwKC0bwZ8rbUDcMpe8A

    @Override
    public Single<LoginResponse> doViewProfileApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_VIEW_PROFILE)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<ViewResturanentsModel> doViewResturanentsApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_VIEW_RESTURANENTS)
                .build()
                .getObjectSingle(ViewResturanentsModel.class);
    }

    @Override
    public Single<AllProductResponse> doViewAllProductsApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVER_GET_VIEW_PRODUCTS_API)
                .build()
                .getObjectSingle(AllProductResponse.class);
    }


    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
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

