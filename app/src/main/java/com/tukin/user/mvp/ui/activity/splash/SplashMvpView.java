

package com.tukin.user.mvp.ui.activity.splash;

import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

public interface SplashMvpView extends MvpView {

    void openLoginActivity();

    void openMainActivity();

    void startSyncService();
}
