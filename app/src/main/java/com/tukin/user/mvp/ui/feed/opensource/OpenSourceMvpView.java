

package com.tukin.user.mvp.ui.feed.opensource;

import com.tukin.user.mvp.data.network.model.OpenSourceResponse;
import com.tukin.user.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by janisharali on 25/05/17.
 */

public interface OpenSourceMvpView extends MvpView {

    void updateRepo(List<OpenSourceResponse.Repo> repoList);
}
