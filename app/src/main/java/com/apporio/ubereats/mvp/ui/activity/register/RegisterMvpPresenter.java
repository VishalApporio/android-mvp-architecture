package com.apporio.ubereats.mvp.ui.activity.register;

import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/11/2018.
 */

public interface RegisterMvpPresenter <V extends RegisterMvpView> extends MvpPresenter<V> {

    void onServerRegister(String first_name, String last_name,String email, String phone_no, String password);

}
