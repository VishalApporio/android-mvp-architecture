

package com.apporio.ubereats.mvp.di.module;

import android.app.Application;
import android.content.Context;

import com.apporio.ubereats.BuildConfig;
import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.db.DbHelper;
import com.apporio.ubereats.mvp.data.network.ApiHelper;
import com.apporio.ubereats.mvp.data.network.AppApiHelper;
import com.apporio.ubereats.mvp.data.prefs.AppPreferencesHelper;
import com.apporio.ubereats.mvp.data.prefs.PreferencesHelper;
import com.apporio.ubereats.mvp.di.ApiInfo;
import com.apporio.ubereats.mvp.di.ApplicationContext;
import com.apporio.ubereats.mvp.di.DatabaseInfo;

import com.apporio.ubereats.mvp.data.AppDataManager;
import com.apporio.ubereats.mvp.data.DataManager;
import com.apporio.ubereats.mvp.data.db.AppDbHelper;
import com.apporio.ubereats.mvp.data.network.ApiHeader;
import com.apporio.ubereats.mvp.di.PreferenceInfo;
import com.apporio.ubereats.mvp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by amitshekhar on 03/02/17.
 */
@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    // TODO : Mock all below for UI testing

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
