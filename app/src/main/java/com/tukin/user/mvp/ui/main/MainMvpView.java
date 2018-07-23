

package com.tukin.user.mvp.ui.main;

import com.tukin.user.mvp.data.db.model.Question;
import com.tukin.user.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

public interface MainMvpView extends MvpView {

    void openLoginActivity();

    void showAboutFragment();

    void refreshQuestionnaire(List<Question> questionList);

    void reloadQuestionnaire(List<Question> questionList);

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void updateAppVersion();

    void showRateUsDialog();

    void openMyFeedActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
