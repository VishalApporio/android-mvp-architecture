

package com.tukin.user.mvp.di.component;

import android.app.Application;
import android.content.Context;

import com.tukin.user.mvp.di.ApplicationContext;
import com.tukin.user.mvp.di.module.ApplicationModule;
import com.tukin.user.mvp.service.SyncService;
import com.tukin.user.mvp.MvpApp;
import com.tukin.user.mvp.data.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}