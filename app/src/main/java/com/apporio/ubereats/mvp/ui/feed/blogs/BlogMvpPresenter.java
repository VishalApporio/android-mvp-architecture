

package com.apporio.ubereats.mvp.ui.feed.blogs;

import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by vishal@apporio.com on 25/05/17.
 */

public interface BlogMvpPresenter<V extends BlogMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}


