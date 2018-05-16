

package com.apporio.ubereats.mvp.ui.feed;

import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.ui.base.MvpView;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;
import com.apporio.ubereats.mvp.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by vishal@apporio.com on 25/05/17.
 */

public class FeedPresenter<V extends MvpView> extends BasePresenter<V> implements
        FeedMvpPresenter<V> {

    private static final String TAG = "FeedPresenter";

    @Inject
    public FeedPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
