package com.tukin.user.mvp.ui.activity.trackRide;

import com.tukin.user.mvp.data.network.model.GetDriverlocationResponse;
import com.tukin.user.mvp.data.network.model.trackRideDriverDetails.ViewDriverDetailsResponse;
import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 5/16/2018.
 */

public interface TrackRideMvpView extends MvpView {

    void getAllDriverDetailsResponse(ViewDriverDetailsResponse viewDriverDetailsResponse);

    void getDriverCurrentLocation(GetDriverlocationResponse getDriverlocationResponse);
}
