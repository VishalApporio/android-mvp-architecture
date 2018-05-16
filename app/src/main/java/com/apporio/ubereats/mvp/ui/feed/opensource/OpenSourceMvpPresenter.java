

package com.apporio.ubereats.mvp.ui.feed.opensource;

import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by vishal@apporio.com on 25/05/17.
 */

public interface OpenSourceMvpPresenter<V extends OpenSourceMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}
