

package com.apporio.ubereats.mvp.di.component;

import com.apporio.ubereats.mvp.di.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by amitshekhar on 03/02/17.
 */
@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}
