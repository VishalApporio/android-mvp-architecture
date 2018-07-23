package com.tukin.user.mvp.ui.fragments.homefragment;

import com.tukin.user.mvp.data.network.model.ViewResturanentsModel;
import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 4/11/2018.
 */

public interface HomeFragmentMvpView extends MvpView {

    void updateAllRestauranentsView(ViewResturanentsModel viewResturanentsModel);

}


