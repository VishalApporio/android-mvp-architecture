

package com.apporio.ubereats.mvp.di.component;

import com.apporio.ubereats.mvp.di.module.ServiceModule;
import com.apporio.ubereats.mvp.service.SyncService;
import com.apporio.ubereats.mvp.di.PerService;

import dagger.Component;

/**
 * Created by vishal@apporio.com on 01/02/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
