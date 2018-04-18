package com.apporio.ubereats.mvp.ui.activity.home;

import com.apporio.ubereats.mvp.data.DataManager;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lenovo on 4/11/2018.
 */

public class HomePresenter <V extends HomeMvpView> extends BasePresenter<V>
        implements HomeMvpPresenter<V> {

    @Inject
    public HomePresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
