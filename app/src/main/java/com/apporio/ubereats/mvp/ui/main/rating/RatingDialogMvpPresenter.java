

package com.apporio.ubereats.mvp.ui.main.rating;

import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by vishal@apporio.com on 22/03/17.
 */

public interface RatingDialogMvpPresenter<V extends RatingDialogMvpView> extends MvpPresenter<V> {

    void onRatingSubmitted(float rating, String message);

    void onCancelClicked();

    void onLaterClicked();

    void onPlayStoreRatingClicked();
}
