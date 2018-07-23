

package com.tukin.user.mvp.data.db;

import com.tukin.user.mvp.data.db.model.DaoMaster;
import com.tukin.user.mvp.data.db.model.DaoSession;
import com.tukin.user.mvp.data.db.model.Option;
import com.tukin.user.mvp.data.db.model.ProductDatadb;
import com.tukin.user.mvp.data.db.model.ProductDatadbDao;
import com.tukin.user.mvp.data.db.model.Question;
import com.tukin.user.mvp.data.db.model.User;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * Created by vishal
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Long> insertUser(final User user) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getUserDao().insert(user);
            }
        });
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return mDaoSession.getUserDao().loadAll();
            }
        });
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return Observable.fromCallable(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return mDaoSession.getQuestionDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getQuestionDao().count() > 0);
            }
        });
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getOptionDao().count() > 0);
            }
        });
    }

    @Override
    public Observable<Boolean> saveQuestion(final Question question) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getQuestionDao().insert(question);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveProductCount(final ProductDatadb productDatadb) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getProductDatadbDao().insert(productDatadb);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveOption(final Option option) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getOptionDao().insertInTx(option);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveQuestionList(final List<Question> questionList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getQuestionDao().insertInTx(questionList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveOptionList(final List<Option> optionList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getOptionDao().insertInTx(optionList);
                return true;
            }
        });
    }

    @Override
    public Observable<List<ProductDatadb>> getAllProductDetails() {
        return Observable.fromCallable(new Callable<List<ProductDatadb>>() {
            @Override
            public List<ProductDatadb> call() throws Exception {
                return mDaoSession.getProductDatadbDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Long> insertProduct(final ProductDatadb productDatadb) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // mDaoSession.queryRaw(ProductDatadb.class, "product_id", "option_cat_id", "", "")
                // ;
                return mDaoSession.getProductDatadbDao().insert(productDatadb);
            }
        });
    }

    @Override
    public Observable<List<ProductDatadb>> updateProduct(final ProductDatadb productDatadb) {
        return Observable.fromCallable(new Callable<List<ProductDatadb>>() {
            @Override
            public List<ProductDatadb> call() throws Exception {

                List<ProductDatadb> productDbs = mDaoSession.getProductDatadbDao().queryBuilder()
                        .where(ProductDatadbDao.Properties.Subb_category_id.eq(productDatadb.getSubb_category_id()))
                        .list();

                for(int i=0;i<productDbs.size();i++)
                {
                    ProductDatadb productDatadb = productDbs.get(i);
                    productDatadb.setCategory_id(productDatadb.getCategory_id());
                    productDatadb.setSubb_category_id(productDatadb.getSubb_category_id());
                    productDatadb.setProduct_id(productDatadb.getProduct_id());
                    productDatadb.setProduct_name(productDatadb.getProduct_name());
                    productDatadb.setProduct_quantity(productDatadb.getProduct_quantity());
                    productDatadb.setProduct_price(productDatadb.getProduct_price());
                    productDatadb.setTotal_price(productDatadb.getTotal_price());
                    productDatadb.setProduct_price_per_unit("");

                    mDaoSession.getProductDatadbDao().update(productDatadb);

                }
                return productDbs;
            }
        });
    }

    @Override
    public Observable<Boolean> clearDatabase() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {

                mDaoSession.getProductDatadbDao().deleteAll();

                for (AbstractDao abstractDao : mDaoSession.getAllDaos()) {
                    abstractDao.deleteAll();

                    mDaoSession.clear();
                    // mDaoSession.getAllDaos().clear();
                }
                return true;
            }
        });
    }


    @Override
    public Observable<Boolean> checkExistance(final int sub_category_id) {

        return  Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                List<ProductDatadb> productDbs = mDaoSession.getProductDatadbDao().queryBuilder()
                        .where(ProductDatadbDao.Properties.Subb_category_id.eq(sub_category_id))
                        .list();

                if(productDbs.size()==0)
                    return false;
                else
                    return true;
            }
        });

    }
}
