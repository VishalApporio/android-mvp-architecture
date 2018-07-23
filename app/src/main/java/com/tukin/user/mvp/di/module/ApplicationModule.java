

package com.tukin.user.mvp.di.module;

import android.app.Application;
import android.content.Context;

import com.tukin.user.BuildConfig;
import com.tukin.user.R;
import com.tukin.user.mvp.data.AppDataManager;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.db.AppDbHelper;
import com.tukin.user.mvp.data.db.DbHelper;
import com.tukin.user.mvp.data.network.ApiHeader;
import com.tukin.user.mvp.data.network.ApiHelper;
import com.tukin.user.mvp.data.network.AppApiHelper;
import com.tukin.user.mvp.data.prefs.AppPreferencesHelper;
import com.tukin.user.mvp.data.prefs.PreferencesHelper;
import com.tukin.user.mvp.di.ApiInfo;
import com.tukin.user.mvp.di.ApplicationContext;
import com.tukin.user.mvp.di.DatabaseInfo;
import com.tukin.user.mvp.di.PreferenceInfo;
import com.tukin.user.mvp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
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
