package com.tukin.user.mvp.ui.activity.trackRide;

import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 5/16/2018.
 */

public interface TrackRideMvpPresenter<V extends TrackRideMvpView> extends MvpPresenter<V> {

    void viewDriverDetailsApi(String order_id);

    void getCurrentDriverLocation(String driver_id);

}
