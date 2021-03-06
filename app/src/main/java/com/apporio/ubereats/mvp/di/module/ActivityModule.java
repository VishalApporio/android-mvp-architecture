

package com.apporio.ubereats.mvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.apporio.ubereats.mvp.data.network.model.BlogResponse;
import com.apporio.ubereats.mvp.data.network.model.OpenSourceResponse;
import com.apporio.ubereats.mvp.di.ActivityContext;
import com.apporio.ubereats.mvp.di.PerActivity;
import com.apporio.ubereats.mvp.location.LocationSession;
import com.apporio.ubereats.mvp.ui.about.AboutMvpPresenter;
import com.apporio.ubereats.mvp.ui.about.AboutMvpView;
import com.apporio.ubereats.mvp.ui.about.AboutPresenter;
import com.apporio.ubereats.mvp.ui.activity.deliveryLocation.DeliveryLocationMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.deliveryLocation.DeliveryLocationMvpView;
import com.apporio.ubereats.mvp.ui.activity.deliveryLocation.DeliveryLocationPresenter;
import com.apporio.ubereats.mvp.ui.activity.home.HomeMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.home.HomeMvpView;
import com.apporio.ubereats.mvp.ui.activity.home.HomePresenter;
import com.apporio.ubereats.mvp.ui.activity.login.LoginMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.login.LoginMvpView;
import com.apporio.ubereats.mvp.ui.activity.login.LoginPresenter;
import com.apporio.ubereats.mvp.ui.activity.profile.ProfileMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.profile.ProfileMvpView;
import com.apporio.ubereats.mvp.ui.activity.profile.ProfilePresenter;
import com.apporio.ubereats.mvp.ui.activity.register.RegisterMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.register.RegisterMvpView;
import com.apporio.ubereats.mvp.ui.activity.register.RegisterPresenter;
import com.apporio.ubereats.mvp.ui.activity.splash.SplashMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.splash.SplashMvpView;
import com.apporio.ubereats.mvp.ui.activity.splash.SplashPresenter;
import com.apporio.ubereats.mvp.ui.activity.viewParticularDish.ViewDishMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.viewParticularDish.ViewDishMvpView;
import com.apporio.ubereats.mvp.ui.activity.viewParticularDish.ViewDishPresenter;
import com.apporio.ubereats.mvp.ui.activity.viewProducts.ViewProductsMvpPresenter;
import com.apporio.ubereats.mvp.ui.activity.viewProducts.ViewProductsMvpView;
import com.apporio.ubereats.mvp.ui.activity.viewProducts.ViewProductsPresenter;
import com.apporio.ubereats.mvp.ui.feed.FeedMvpPresenter;
import com.apporio.ubereats.mvp.ui.feed.FeedMvpView;
import com.apporio.ubereats.mvp.ui.feed.FeedPagerAdapter;
import com.apporio.ubereats.mvp.ui.feed.FeedPresenter;
import com.apporio.ubereats.mvp.ui.feed.blogs.BlogAdapter;
import com.apporio.ubereats.mvp.ui.feed.blogs.BlogMvpPresenter;
import com.apporio.ubereats.mvp.ui.feed.blogs.BlogMvpView;
import com.apporio.ubereats.mvp.ui.feed.blogs.BlogPresenter;
import com.apporio.ubereats.mvp.ui.feed.opensource.OpenSourceAdapter;
import com.apporio.ubereats.mvp.ui.feed.opensource.OpenSourceMvpPresenter;
import com.apporio.ubereats.mvp.ui.feed.opensource.OpenSourceMvpView;
import com.apporio.ubereats.mvp.ui.feed.opensource.OpenSourcePresenter;
import com.apporio.ubereats.mvp.ui.fragments.homefragment.HomeFragmentMvpPresenter;
import com.apporio.ubereats.mvp.ui.fragments.homefragment.HomeFragmentMvpView;
import com.apporio.ubereats.mvp.ui.fragments.homefragment.HomeFragmentPresenter;
import com.apporio.ubereats.mvp.ui.fragments.settings.SettingMvpPresenter;
import com.apporio.ubereats.mvp.ui.fragments.settings.SettingsMvpView;
import com.apporio.ubereats.mvp.ui.fragments.settings.SettingsPresenter;
import com.apporio.ubereats.mvp.ui.main.MainMvpPresenter;
import com.apporio.ubereats.mvp.ui.main.MainMvpView;
import com.apporio.ubereats.mvp.ui.main.MainPresenter;
import com.apporio.ubereats.mvp.ui.main.rating.RatingDialogMvpPresenter;
import com.apporio.ubereats.mvp.ui.main.rating.RatingDialogMvpView;
import com.apporio.ubereats.mvp.ui.main.rating.RatingDialogPresenter;
import com.apporio.ubereats.mvp.utils.rx.AppSchedulerProvider;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by vishal@apporio.com on 27/01/17.
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
