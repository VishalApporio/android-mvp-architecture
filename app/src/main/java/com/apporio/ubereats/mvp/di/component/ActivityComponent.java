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

package com.apporio.ubereats.mvp.di.component;

import com.apporio.ubereats.mvp.di.PerActivity;
import com.apporio.ubereats.mvp.ui.about.AboutFragment;
import com.apporio.ubereats.mvp.ui.activity.profile.ProfileViewActivity;
import com.apporio.ubereats.mvp.ui.feed.FeedActivity;
import com.apporio.ubereats.mvp.ui.feed.blogs.BlogFragment;
import com.apporio.ubereats.mvp.ui.feed.opensource.OpenSourceFragment;
import com.apporio.ubereats.mvp.ui.activity.home.HomeActivity;
import com.apporio.ubereats.mvp.ui.activity.login.LoginActivity;
import com.apporio.ubereats.mvp.ui.fragments.homefragment.HomeFragment;
import com.apporio.ubereats.mvp.ui.fragments.orders.MainOrdersRecordFragment;
import com.apporio.ubereats.mvp.ui.fragments.searchRestauranent.SearchResturanentFragment;
import com.apporio.ubereats.mvp.ui.fragments.settings.SettingsMenuFragment;
import com.apporio.ubereats.mvp.ui.main.MainActivity;
import com.apporio.ubereats.mvp.ui.main.rating.RateUsDialog;
import com.apporio.ubereats.mvp.di.module.ActivityModule;
import com.apporio.ubereats.mvp.ui.activity.register.RegisterActivity;
import com.apporio.ubereats.mvp.ui.activity.splash.SplashActivity;

import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(RegisterActivity activity);

    void inject(HomeActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(ProfileViewActivity activity);

    void inject(AboutFragment fragment);

    void inject(HomeFragment fragment);

    void inject(SearchResturanentFragment SearchResturanentFragment);

    void inject(MainOrdersRecordFragment mainOrdersRecordFragment);

    void inject(SettingsMenuFragment settingsMenuFragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

}
