

package com.tukin.user.mvp.ui.feed;

import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.ui.base.MvpView;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;
import com.tukin.user.mvp.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 25/05/17.
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
