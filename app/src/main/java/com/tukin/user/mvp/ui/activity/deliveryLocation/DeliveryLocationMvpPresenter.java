package com.tukin.user.mvp.ui.activity.deliveryLocation;

import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/19/2018.
 */

public interface DeliveryLocationMvpPresenter<V extends DeliveryLocationMvpView> extends MvpPresenter<V> {

    void onViewAutoCompleteAddress(String value, Double latitude, Double longitude, String google_key);

    void getAddressFromApi(String place_id, String google_api_key);
}
