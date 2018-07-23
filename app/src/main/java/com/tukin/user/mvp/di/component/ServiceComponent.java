

package com.tukin.user.mvp.di.component;

import com.tukin.user.mvp.di.module.ServiceModule;
import com.tukin.user.mvp.service.SyncService;
import com.tukin.user.mvp.di.PerService;

import dagger.Component;

/**
 * Created by janisharali on 01/02/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
