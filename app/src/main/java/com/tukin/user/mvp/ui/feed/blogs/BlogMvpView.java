

package com.tukin.user.mvp.ui.feed.blogs;

import com.tukin.user.mvp.data.network.model.BlogResponse;
import com.tukin.user.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by janisharali on 25/05/17.
 */

public interface BlogMvpView extends MvpView {

    void updateBlog(List<BlogResponse.Blog> blogList);
}
