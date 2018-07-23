package com.tukin.user.mvp.ui.activity.deliveryLocation;

import com.tukin.user.mvp.data.network.model.GetLocationsModelClass;
import com.tukin.user.mvp.di.others.PlaceAutoComplete;
import com.tukin.user.mvp.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by lenovo on 4/19/2018.
 */

public interface DeliveryLocationMvpView extends MvpView {

    void onViewAfterCallingAPi();

    void onViewAfterListIsEmty();

    void onViewAfterListisNotEmpty();

    void onViewErrorOcurred();

    void onCLickListItem();

    void getPlaces(ArrayList<PlaceAutoComplete> getPlaces);

    void getSelectedLocation(GetLocationsModelClass getLocationsModelClass);

}
