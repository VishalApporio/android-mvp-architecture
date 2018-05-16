

package com.apporio.ubereats.mvp.di.component;

import com.apporio.ubereats.mvp.di.PerActivity;
import com.apporio.ubereats.mvp.ui.about.AboutFragment;
import com.apporio.ubereats.mvp.ui.activity.deliveryLocation.DeliveryLocationActivity;
import com.apporio.ubereats.mvp.ui.activity.profile.ProfileViewActivity;
import com.apporio.ubereats.mvp.ui.activity.viewParticularDish.ViewDishActivity;
import com.apporio.ubereats.mvp.ui.activity.viewProducts.ViewProductsActivity;
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
import dagger.Provides;

/**
 * Created by vishal@apporio.com on 27/01/17.
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

    void inject(DeliveryLocationActivity activity);

    void inject(AboutFragment fragment);

    void inject(HomeFragment fragment);

    void inject(ViewProductsActivity activity);

    void inject(ViewDishActivity activity);

    void inject(SearchResturanentFragment SearchResturanentFragment);

    void inject(MainOrdersRecordFragment mainOrdersRecordFragment);

    void inject(SettingsMenuFragment settingsMenuFragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

}
