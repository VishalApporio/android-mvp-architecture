

package com.apporio.ubereats.mvp.ui.feed.blogs;

import com.apporio.ubereats.mvp.data.network.model.BlogResponse;
import com.apporio.ubereats.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by vishal@apporio.com on 25/05/17.
 */

public interface BlogMvpView extends MvpView {

    void updateBlog(List<BlogResponse.Blog> blogList);
}
