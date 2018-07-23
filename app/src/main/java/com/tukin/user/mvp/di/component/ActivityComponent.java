

package com.tukin.user.mvp.di.component;

import com.tukin.user.mvp.di.PerActivity;
import com.tukin.user.mvp.ui.about.AboutFragment;
import com.tukin.user.mvp.ui.activity.deliveryLocation.DeliveryLocationActivity;
import com.tukin.user.mvp.ui.activity.profile.ProfileViewActivity;
import com.tukin.user.mvp.ui.activity.trackRide.TrackRideActivty;
import com.tukin.user.mvp.ui.activity.viewCart.ViewCartActivity;
import com.tukin.user.mvp.ui.activity.viewParticularDish.ViewDishActivity;
import com.tukin.user.mvp.ui.activity.viewProducts.ViewProductsActivity;
import com.tukin.user.mvp.ui.feed.FeedActivity;
import com.tukin.user.mvp.ui.feed.blogs.BlogFragment;
import com.tukin.user.mvp.ui.feed.opensource.OpenSourceFragment;
import com.tukin.user.mvp.ui.activity.home.HomeActivity;
import com.tukin.user.mvp.ui.activity.login.LoginActivity;
import com.tukin.user.mvp.ui.fragments.homefragment.HomeFragment;
import com.tukin.user.mvp.ui.fragments.orders.mainOrder.MainOrdersRecordFragment;
import com.tukin.user.mvp.ui.fragments.searchRestauranent.SearchResturanentFragment;
import com.tukin.user.mvp.ui.fragments.settings.SettingsMenuFragment;
import com.tukin.user.mvp.ui.main.MainActivity;
import com.tukin.user.mvp.ui.main.rating.RateUsDialog;
import com.tukin.user.mvp.di.module.ActivityModule;
import com.tukin.user.mvp.ui.activity.register.RegisterActivity;
import com.tukin.user.mvp.ui.activity.splash.SplashActivity;

import dagger.Component;

/**
 * Created by vishal@apporio.com on 05/03/18.
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

    void inject(ViewCartActivity activity);

    void inject(TrackRideActivty activity);

    void inject(SearchResturanentFragment SearchResturanentFragment);

    void inject(MainOrdersRecordFragment mainOrdersRecordFragment);

    void inject(SettingsMenuFragment settingsMenuFragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

}
