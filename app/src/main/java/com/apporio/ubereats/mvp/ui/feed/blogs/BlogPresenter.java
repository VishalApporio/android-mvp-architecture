

package com.apporio.ubereats.mvp.ui.feed.blogs;

import com.androidnetworking.error.ANError;
import com.apporio.ubereats.mvp.data.network.model.BlogResponse;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;
import com.apporio.ubereats.mvp.data.DataManager;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by vishal@apporio.com on 25/05/17.
 */

public class BlogPresenter<V extends BlogMvpView> extends BasePresenter<V>
        implements BlogMvpPresenter<V> {

    @Inject
    public BlogPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<BlogResponse>() {
                    @Override
                    public void accept(@NonNull BlogResponse blogResponse)
                            throws Exception {
                        if (blogResponse != null && blogResponse.getData() != null) {
                            getMvpView().updateBlog(blogResponse.getData());
                        }
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
