

package com.tukin.user.mvp.data;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.tukin.user.mvp.data.db.DbHelper;
import com.tukin.user.mvp.data.db.model.CheckOutResponse;
import com.tukin.user.mvp.data.db.model.Option;
import com.tukin.user.mvp.data.db.model.ProductDatadb;
import com.tukin.user.mvp.data.db.model.Question;
import com.tukin.user.mvp.data.db.model.User;
import com.tukin.user.mvp.data.db.model.ViewCartResponse;
import com.tukin.user.mvp.data.db.model.orderHistory.OrderHistoryResponse;
import com.tukin.user.mvp.data.network.ApiHeader;
import com.tukin.user.mvp.data.network.ApiHelper;
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
import com.tukin.user.mvp.data.prefs.PreferencesHelper;
import com.tukin.user.mvp.di.ApplicationContext;
import com.tukin.user.mvp.di.others.PlacePredictions;
import com.tukin.user.mvp.utils.AppConstants;
import com.tukin.user.mvp.utils.CommonUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public Observable<Long> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                              request) {
        return mApiHelper.doGoogleLoginApiCall(request);
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                request) {
        return mApiHelper.doFacebookLoginApiCall(request);
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                              request) {
        return mApiHelper.doServerLoginApiCall(request);
    }

    @Override
    public Single<LoginResponse> doServerRegisterApiCall(LoginRequest.ServerRegisterRequest request) {
        return mApiHelper.doServerRegisterApiCall(request);
    }

    @Override
    public Single<LoginResponse> doViewProfileApiCall(HashMap<String, String> bodyparameter) {
        return mApiHelper.doViewProfileApiCall(bodyparameter);
    }

    @Override
    public Single<ViewDriverDetailsResponse> doViewAllDriverDetails(HashMap<String, String> bodyparameter) {
        return mApiHelper.doViewAllDriverDetails(bodyparameter);
    }

    @Override
    public Single<GetDriverlocationResponse> doGetDriverCurrentLocation(HashMap<String, String> bodyparameter) {
        return mApiHelper.doGetDriverCurrentLocation(bodyparameter);
    }

    @Override
    public Single<LoginResponse> doEditProfileApiCall(HashMap<String, String> bodyparameter, HashMap<String, File> images) {
        return mApiHelper.doEditProfileApiCall(bodyparameter, images);
    }

    @Override
    public Single<CheckOutResponse> doServerCheckOut(HashMap<String, String> bodyparameter) {
        return mApiHelper.doServerCheckOut(bodyparameter);
    }

    @Override
    public Single<ViewResturanentsModel> doViewResturanentsApiCall() {
        return mApiHelper.doViewResturanentsApiCall();
    }

    @Override
    public Single<UpdateDeviceIdResponse> doUpdateDeviceId(HashMap<String, String> bodyparameter) {
        return mApiHelper.doUpdateDeviceId(bodyparameter);
    }

    @Override
    public Single<OrderHistoryResponse> doViewAllOrderHistory(HashMap<String, String> bodyparameter) {
        return mApiHelper.doViewAllOrderHistory(bodyparameter);
    }

    @Override
    public Single<ViewProductResponse> doViewAllProductsApiCall(HashMap<String, String> bodyparameter) {
        return mApiHelper.doViewAllProductsApiCall(bodyparameter);
    }

    @Override
    public Single<PlacePredictions> doAutoCompleteApiCall(String value, Double latitude, Double longitude, String google_key) {
        return mApiHelper.doAutoCompleteApiCall(value, latitude, longitude, google_key);
    }

    @Override
    public Single<GetLocationsModelClass> doGetLocationApiCall(String place_id, String google_key) {
        return mApiHelper.doGetLocationApiCall(place_id, google_key);
    }

    @Override
    public Single<ViewCartResponse> doCallApiForViewCart(HashMap<String, String> bodyparameters) {
        return mApiHelper.doCallApiForViewCart(bodyparameters);
    }

    @Override
    public Single<CheckOutResponse> doCallApiForPlaceOrder(HashMap<String, String> bodyparameter) {
        return mApiHelper.doCallApiForPlaceOrder(bodyparameter);
    }

    @Override
    public Single<LoginResponse> doLogoutApiCall(HashMap<String, String> bodyparametere) {
        return mApiHelper.doLogoutApiCall(bodyparametere);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath) {

        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
        setCurrentUserProfilePicUrl(profilePicPath);

        updateApiHeader(userId, accessToken);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return mDbHelper.isQuestionEmpty();
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return mDbHelper.isOptionEmpty();
    }

    @Override
    public Observable<Boolean> saveQuestion(Question question) {
        return mDbHelper.saveQuestion(question);
    }

    @Override
    public Observable<Boolean> saveProductCount(ProductDatadb productDatadb) {
        return mDbHelper.saveProductCount(productDatadb);
    }

    @Override
    public Observable<Boolean> saveOption(Option option) {
        return mDbHelper.saveOption(option);
    }

    @Override
    public Observable<Boolean> saveQuestionList(List<Question> questionList) {
        return mDbHelper.saveQuestionList(questionList);
    }

    @Override
    public Observable<Boolean> saveOptionList(List<Option> optionList) {
        return mDbHelper.saveOptionList(optionList);
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return mDbHelper.getAllQuestions();
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDbHelper.isQuestionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = $Gson$Types
                                    .newParameterizedTypeWithOwner(null, List.class,
                                            Question.class);
                            List<Question> questionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(mContext,
                                            AppConstants.SEED_DATABASE_QUESTIONS),
                                    type);

                            return saveQuestionList(questionList);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDbHelper.isOptionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = new TypeToken<List<Option>>() {
                            }
                                    .getType();
                            List<Option> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(mContext,
                                            AppConstants.SEED_DATABASE_OPTIONS),
                                    type);

                            return saveOptionList(optionList);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return mApiHelper.getBlogApiCall();
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return mApiHelper.getOpenSourceApiCall();
    }

    @Override
    public Observable<List<ProductDatadb>> getAllProductDetails() {
        return mDbHelper.getAllProductDetails();
    }

    @Override
    public Observable<Long> insertProduct(ProductDatadb productDatadb) {

        return mDbHelper.insertProduct(productDatadb);
    }

    @Override
    public Observable<List<ProductDatadb>> updateProduct(ProductDatadb productDatadb) {

        return mDbHelper.updateProduct(productDatadb);
    }

    @Override
    public Observable<Boolean> clearDatabase() {

        return mDbHelper.clearDatabase();
    }

    @Override
    public Observable<Boolean> checkExistance(int sub_category_id) {
        return mDbHelper.checkExistance(sub_category_id);
    }
}
