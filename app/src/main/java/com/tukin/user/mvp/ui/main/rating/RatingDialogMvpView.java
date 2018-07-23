

package com.tukin.user.mvp.ui.main.rating;

import com.tukin.user.mvp.ui.base.DialogMvpView;

/**
 * Created by janisharali on 24/05/17.
 */

public interface RatingDialogMvpView extends DialogMvpView {

    void openPlayStoreForRating();

    void showPlayStoreRatingView();

    void showRatingMessageView();

    void hideSubmitButton();

    void disableRatingStars();

    void dismissDialog();
}