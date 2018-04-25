package com.apporio.ubereats.mvp.ui.fragments.homefragment;

import com.apporio.ubereats.mvp.data.network.model.ViewResturanentsModel;
import com.apporio.ubereats.mvp.ui.activity.home.HomeMvpView;
import com.apporio.ubereats.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 4/11/2018.
 */

public interface HomeFragmentMvpView extends MvpView {

    void updateAllRestauranentsView(ViewResturanentsModel viewResturanentsModel);

}


