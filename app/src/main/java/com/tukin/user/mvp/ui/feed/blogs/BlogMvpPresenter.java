

package com.tukin.user.mvp.ui.feed.blogs;

import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by janisharali on 25/05/17.
 */

public interface BlogMvpPresenter<V extends BlogMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}


