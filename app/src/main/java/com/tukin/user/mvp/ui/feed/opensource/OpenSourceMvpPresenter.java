

package com.tukin.user.mvp.ui.feed.opensource;

import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by janisharali on 25/05/17.
 */

public interface OpenSourceMvpPresenter<V extends OpenSourceMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}
