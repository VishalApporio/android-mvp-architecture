

package com.apporio.ubereats.mvp.ui.activity.splash;

import com.apporio.ubereats.mvp.ui.base.MvpView;

/**
 * Created by vishal@apporio.com on 27/01/17.
 */

public interface SplashMvpView extends MvpView {

    void openLoginActivity();

    void openMainActivity();

    void startSyncService();
}
