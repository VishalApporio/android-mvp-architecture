

package com.apporio.ubereats.mvp.di.component;

import android.app.Application;
import android.content.Context;

import com.apporio.ubereats.mvp.di.ApplicationContext;
import com.apporio.ubereats.mvp.di.module.ApplicationModule;
import com.apporio.ubereats.mvp.service.SyncService;
import com.apporio.ubereats.mvp.MvpApp;
import com.apporio.ubereats.mvp.data.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vishal@apporio.com on 27/01/17.
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