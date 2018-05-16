

package com.apporio.ubereats.mvp.ui.feed.opensource;

import com.apporio.ubereats.mvp.data.network.model.OpenSourceResponse;
import com.apporio.ubereats.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by vishal@apporio.com on 25/05/17.
 */

public interface OpenSourceMvpView extends MvpView {

    void updateRepo(List<OpenSourceResponse.Repo> repoList);
}
