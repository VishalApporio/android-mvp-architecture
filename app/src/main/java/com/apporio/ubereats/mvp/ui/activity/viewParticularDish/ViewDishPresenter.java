package com.apporio.ubereats.mvp.ui.activity.viewParticularDish;

import com.apporio.ubereats.mvp.data.DataManager;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lenovo on 4/26/2018.
 */

public class ViewDishPresenter<V extends ViewDishMvpView> extends BasePresenter<V>
        implements ViewDishMvpPresenter<V>  {

    @Inject
    public ViewDishPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
