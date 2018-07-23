

package com.tukin.user.mvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.tukin.user.mvp.data.network.model.BlogResponse;
import com.tukin.user.mvp.data.network.model.OpenSourceResponse;
import com.tukin.user.mvp.di.ActivityContext;
import com.tukin.user.mvp.di.PerActivity;
import com.tukin.user.mvp.location.LocationSession;
import com.tukin.user.mvp.ui.about.AboutMvpPresenter;
import com.tukin.user.mvp.ui.about.AboutMvpView;
import com.tukin.user.mvp.ui.about.AboutPresenter;
import com.tukin.user.mvp.ui.activity.deliveryLocation.DeliveryLocationMvpPresenter;
import com.tukin.user.mvp.ui.activity.deliveryLocation.DeliveryLocationMvpView;
import com.tukin.user.mvp.ui.activity.deliveryLocation.DeliveryLocationPresenter;
import com.tukin.user.mvp.ui.activity.home.HomeMvpPresenter;
import com.tukin.user.mvp.ui.activity.home.HomeMvpView;
import com.tukin.user.mvp.ui.activity.home.HomePresenter;
import com.tukin.user.mvp.ui.activity.login.LoginMvpPresenter;
import com.tukin.user.mvp.ui.activity.login.LoginMvpView;
import com.tukin.user.mvp.ui.activity.login.LoginPresenter;
import com.tukin.user.mvp.ui.activity.profile.ProfileMvpPresenter;
import com.tukin.user.mvp.ui.activity.profile.ProfileMvpView;
import com.tukin.user.mvp.ui.activity.profile.ProfilePresenter;
import com.tukin.user.mvp.ui.activity.register.RegisterMvpPresenter;
import com.tukin.user.mvp.ui.activity.register.RegisterMvpView;
import com.tukin.user.mvp.ui.activity.register.RegisterPresenter;
import com.tukin.user.mvp.ui.activity.splash.SplashMvpPresenter;
import com.tukin.user.mvp.ui.activity.splash.SplashMvpView;
import com.tukin.user.mvp.ui.activity.splash.SplashPresenter;
import com.tukin.user.mvp.ui.activity.trackRide.TrackRideMvpPresenter;
import com.tukin.user.mvp.ui.activity.trackRide.TrackRideMvpView;
import com.tukin.user.mvp.ui.activity.trackRide.TrackRidePresenter;
import com.tukin.user.mvp.ui.activity.viewCart.ViewCartMvpPresenter;
import com.tukin.user.mvp.ui.activity.viewCart.ViewCartMvpView;
import com.tukin.user.mvp.ui.activity.viewCart.ViewCartPresenter;
import com.tukin.user.mvp.ui.activity.viewParticularDish.ViewDishMvpPresenter;
import com.tukin.user.mvp.ui.activity.viewParticularDish.ViewDishMvpView;
import com.tukin.user.mvp.ui.activity.viewParticularDish.ViewDishPresenter;
import com.tukin.user.mvp.ui.activity.viewProducts.ViewProductsMvpPresenter;
import com.tukin.user.mvp.ui.activity.viewProducts.ViewProductsMvpView;
import com.tukin.user.mvp.ui.activity.viewProducts.ViewProductsPresenter;
import com.tukin.user.mvp.ui.feed.FeedMvpPresenter;
import com.tukin.user.mvp.ui.feed.FeedMvpView;
import com.tukin.user.mvp.ui.feed.FeedPagerAdapter;
import com.tukin.user.mvp.ui.feed.FeedPresenter;
import com.tukin.user.mvp.ui.feed.blogs.BlogAdapter;
import com.tukin.user.mvp.ui.feed.blogs.BlogMvpPresenter;
import com.tukin.user.mvp.ui.feed.blogs.BlogMvpView;
import com.tukin.user.mvp.ui.feed.blogs.BlogPresenter;
import com.tukin.user.mvp.ui.feed.opensource.OpenSourceAdapter;
import com.tukin.user.mvp.ui.feed.opensource.OpenSourceMvpPresenter;
import com.tukin.user.mvp.ui.feed.opensource.OpenSourceMvpView;
import com.tukin.user.mvp.ui.feed.opensource.OpenSourcePresenter;
import com.tukin.user.mvp.ui.fragments.homefragment.HomeFragmentMvpPresenter;
import com.tukin.user.mvp.ui.fragments.homefragment.HomeFragmentMvpView;
import com.tukin.user.mvp.ui.fragments.homefragment.HomeFragmentPresenter;
import com.tukin.user.mvp.ui.fragments.orders.mainOrder.MainOrderMvpPresenter;
import com.tukin.user.mvp.ui.fragments.orders.mainOrder.MainOrderMvpView;
import com.tukin.user.mvp.ui.fragments.orders.mainOrder.MainOrderPresenter;
import com.tukin.user.mvp.ui.fragments.settings.SettingMvpPresenter;
import com.tukin.user.mvp.ui.fragments.settings.SettingsMvpView;
import com.tukin.user.mvp.ui.fragments.settings.SettingsPresenter;
import com.tukin.user.mvp.ui.main.MainMvpPresenter;
import com.tukin.user.mvp.ui.main.MainMvpView;
import com.tukin.user.mvp.ui.main.MainPresenter;
import com.tukin.user.mvp.ui.main.rating.RatingDialogMvpPresenter;
import com.tukin.user.mvp.ui.main.rating.RatingDialogMvpView;
import com.tukin.user.mvp.ui.main.rating.RatingDialogPresenter;
import com.tukin.user.mvp.utils.rx.AppSchedulerProvider;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    RegisterMvpPresenter<RegisterMvpView> provideRegisterPresenter(
            RegisterPresenter<RegisterMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DeliveryLocationMvpPresenter<DeliveryLocationMvpView> provideDeliveryLocationPresenter(
            DeliveryLocationPresenter<DeliveryLocationMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeMvpView> provideHomePresenter(
            HomePresenter<HomeMvpView> presenter) {
        return presenter;
    }

    @Provides
    HomeFragmentMvpPresenter<HomeFragmentMvpView> provideHomeFragmentPresenter(
            HomeFragmentPresenter<HomeFragmentMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainOrderMvpPresenter<MainOrderMvpView> provideMainOrderPresenter(
            MainOrderPresenter<MainOrderMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ViewCartMvpPresenter<ViewCartMvpView> provideViewCartPresenter(
            ViewCartPresenter<ViewCartMvpView> presenter) {
        return presenter;
    }

    @Provides
    ViewProductsMvpPresenter<ViewProductsMvpView> provideViewProductsPresenter(
            ViewProductsPresenter<ViewProductsMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ViewDishMvpPresenter<ViewDishMvpView> provideViewDishPresenter(
            ViewDishPresenter<ViewDishMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TrackRideMvpPresenter<TrackRideMvpView> provideTrackRidePresenter(
            TrackRidePresenter<TrackRideMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SettingMvpPresenter<SettingsMvpView> provideSettingsPresenter(
            SettingsPresenter<SettingsMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ProfileMvpPresenter<ProfileMvpView> provideProfilePresenter(
            ProfilePresenter<ProfileMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    LocationSession provideLocationSession(AppCompatActivity activity) {

        return new LocationSession(activity);
    }

}
