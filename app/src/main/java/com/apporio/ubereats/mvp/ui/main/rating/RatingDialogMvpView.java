

package com.apporio.ubereats.mvp.ui.main.rating;

import com.apporio.ubereats.mvp.ui.base.DialogMvpView;

/**
 * Created by vishal@apporio.com on 24/05/17.
 */

public interface RatingDialogMvpView extends DialogMvpView {

    void openPlayStoreForRating();

    void showPlayStoreRatingView();

    void showRatingMessageView();

    void hideSubmitButton();

    void disableRatingStars();

    void dismissDialog();
}
