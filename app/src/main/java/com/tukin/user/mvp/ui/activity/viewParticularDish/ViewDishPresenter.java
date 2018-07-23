package com.tukin.user.mvp.ui.activity.viewParticularDish;

import android.annotation.SuppressLint;
import android.util.Log;

import com.androidnetworking.error.ANError;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.db.model.CheckOutResponse;
import com.tukin.user.mvp.data.db.model.ProductDatadb;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/26/2018.
 */

public class ViewDishPresenter<V extends ViewDishMvpView> extends BasePresenter<V>
        implements ViewDishMvpPresenter<V> {


    String mCategory_id, user_id;
    Integer setValue = 0;

    @Inject
    public ViewDishPresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @SuppressLint("CheckResult")
    @Override
    public void saveProductDetailsTODatabase(final String category_id, final String sub_category_id, final Integer product_id, final String product_name, final Integer product_quantity, final String product_price, final Integer total_price) {

        user_id = getDataManager().getCurrentUserId().toString();
        mCategory_id = category_id;
        Log.e("Category_id", "" + category_id);
        Log.e("Sub_category_id", "" + sub_category_id);

        final ProductDatadb productDatadb = new ProductDatadb();
        productDatadb.setCategory_id(category_id);
        productDatadb.setSubb_category_id(sub_category_id);
        productDatadb.setProduct_id(product_id);
        productDatadb.setProduct_name(product_name);
        productDatadb.setProduct_quantity(product_quantity);
        productDatadb.setProduct_price(product_price);
        productDatadb.setTotal_price(total_price);
        productDatadb.setProduct_price_per_unit("");

        getDataManager().getAllProductDetails()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<ProductDatadb>>() {
                    @Override
                    public void accept(List<ProductDatadb> productDatadbList) throws Exception {

                        if (productDatadbList.size() != 0) {
                            Log.e("ProductList", "" + productDatadbList);
                            for (int i = 0; i < productDatadbList.size(); i++) {
                                Log.e("ProductId", "" + productDatadbList.get(i).getProduct_id());
                                Log.e("ProductListName", "" + productDatadbList.get(i).getProduct_name());
                            }

                            getCompositeDisposable().add(getDataManager()
                                    .checkExistance(Integer.parseInt(sub_category_id))
                                    .subscribeOn(getSchedulerProvider().io())
                                    .observeOn(getSchedulerProvider().ui())
                                    .subscribe(new Consumer<Boolean>() {
                                        @Override
                                        public void accept(Boolean bolean) throws Exception {
                                            getMvpView().hideLoading();

                                            if (bolean == true) {

                                               // getMvpView().showMessage("Exist");

                                                getCompositeDisposable().add(getDataManager()
                                                        .updateProduct(productDatadb)
                                                        .subscribeOn(getSchedulerProvider().io())
                                                        .observeOn(getSchedulerProvider().ui())
                                                        .subscribe(new Consumer<List<ProductDatadb>>() {
                                                            @Override
                                                            public void accept(List<ProductDatadb> list) throws Exception {

                                                               // getMvpView().showMessage("Updated SuccuessFully");
                                                                getMvpView().checkDetailsInDatabase();
                                                            }
                                                        }, new Consumer<Throwable>() {
                                                            @Override
                                                            public void accept(Throwable throwable) throws Exception {
                                                                getMvpView().showMessage("Error" + throwable.getMessage());
                                                            }
                                                        }));

                                            } else {

                                                getDataManager().insertProduct(productDatadb)
                                                        .subscribeOn(getSchedulerProvider().io())
                                                        .observeOn(getSchedulerProvider().ui())
                                                        .subscribe(new Consumer<Long>() {
                                                            @Override
                                                            public void accept(Long aLong) throws Exception {
                                                               // getMvpView().showMessage("Saved successfully Insert" + aLong);
                                                                getMvpView().checkDetailsInDatabase();
                                                            }
                                                        }, new Consumer<Throwable>() {
                                                            @Override
                                                            public void accept(Throwable throwable) throws Exception {
                                                                getMvpView().showMessage("Some error occured " + throwable.getMessage());
                                                            }
                                                        });

                                                getMvpView().showMessage("Not exist");
                                            }

                                        }
                                    }, new Consumer<Throwable>() {
                                        @Override
                                        public void accept(Throwable throwable) throws Exception {
                                            getMvpView().showMessage("Error  Check Existnace" + throwable.getMessage());
                                        }
                                    }));
                        } else {

                            getDataManager().insertProduct(productDatadb)
                                    .subscribeOn(getSchedulerProvider().io())
                                    .observeOn(getSchedulerProvider().ui())
                                    .subscribe(new Consumer<Long>() {
                                        @Override
                                        public void accept(Long aLong) throws Exception {
                                          //  getMvpView().showMessage("Saved successfully Insert" + aLong);
                                            getMvpView().checkDetailsInDatabase();
                                        }
                                    }, new Consumer<Throwable>() {
                                        @Override
                                        public void accept(Throwable throwable) throws Exception {
                                            getMvpView().showMessage("Some error occured " + throwable.getMessage());
                                        }
                                    });


                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().showMessage("Some error occured " + throwable.getMessage());
                    }
                });

    }

    @SuppressLint("CheckResult")
    @Override
    public void isProductDetailsAvailable() {

        user_id = getDataManager().getCurrentUserId().toString();

        getDataManager().getAllProductDetails()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<ProductDatadb>>() {
                    @Override
                    public void accept(List<ProductDatadb> productDatadbList) throws Exception {
                        if (productDatadbList != null)

                        {
                            if (productDatadbList.size() != 0) {
                                Log.e("ProductList", "" + productDatadbList);
                                for (int i = 0; i < productDatadbList.size(); i++) {
                                    Log.e("ProductId", "" + productDatadbList.get(i).getProduct_id());
                                    Log.e("ProductListName", "" + productDatadbList.get(i).getProduct_name());
                                }

                                getMvpView().showCheckOutButton("0", productDatadbList, user_id);
                            }
                        } else {
                            getMvpView().showCheckOutButton("1", productDatadbList, user_id);

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().showMessage("Some error occured " + throwable.getMessage());
                    }
                });

    }

    @SuppressLint("CheckResult")
    @Override
    public void clearDatabaseithCheckOut(final JSONArray jsonArray) {

        getDataManager().getAllProductDetails()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<ProductDatadb>>() {
                    @Override
                    public void accept(List<ProductDatadb> productDatadbList) throws Exception {

                        if (productDatadbList != null) {

                            if (productDatadbList.size() != 0) {
                                getDataManager().clearDatabase()
                                        .subscribeOn(getSchedulerProvider().io())
                                        .observeOn(getSchedulerProvider().ui())
                                        .subscribe(new Consumer<Boolean>() {
                                            @Override
                                            public void accept(Boolean aBoolean) throws Exception {

                                                HashMap<String, String> data = new HashMap<>();
                                                data.put("cart_data", "" + jsonArray);
                                                data.put("language_code", "" + "en");

                                                getCompositeDisposable().add(getDataManager()
                                                        .doServerCheckOut(data)
                                                        .subscribeOn(getSchedulerProvider().io())
                                                        .observeOn(getSchedulerProvider().ui())
                                                        .subscribe(new Consumer<CheckOutResponse>() {
                                                            @Override
                                                            public void accept(CheckOutResponse response) throws Exception {

                                                                if (!isViewAttached()) {
                                                                    return;
                                                                }

                                                                getMvpView().hideLoading();

                                                                getDataManager().clearDatabase();

                                                                getMvpView().showMessage(response.getMessage());

                                                                getMvpView().openViewCartActivity();

                                                            }
                                                        }, new Consumer<Throwable>() {
                                                            @Override
                                                            public void accept(Throwable throwable) throws Exception {

                                                                if (!isViewAttached()) {
                                                                    return;
                                                                }

                                                                getMvpView().hideLoading();

                                                                // handle the login error here
                                                                if (throwable instanceof ANError) {
                                                                    ANError anError = (ANError) throwable;
                                                                    handleApiError(anError);
                                                                }
                                                            }
                                                        }));


                                            }
                                        });
                            }

                        }
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().showMessage("Some error occured " + throwable.getMessage());
                    }
                });


    }

}
