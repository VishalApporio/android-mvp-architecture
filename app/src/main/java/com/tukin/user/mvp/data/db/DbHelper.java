

package com.tukin.user.mvp.data.db;

import com.tukin.user.mvp.data.db.model.Option;
import com.tukin.user.mvp.data.db.model.ProductDatadb;
import com.tukin.user.mvp.data.db.model.Question;
import com.tukin.user.mvp.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by janisharali on 08/12/16.
 */

public interface DbHelper {

    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveProductCount(ProductDatadb productDatadb);

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);

    Observable<List<ProductDatadb>> getAllProductDetails();

    Observable<Long> insertProduct(final ProductDatadb productDatadb);

    Observable<List<ProductDatadb>> updateProduct(final ProductDatadb productDatadb);


    Observable<Boolean> clearDatabase();

    Observable<Boolean> checkExistance(int sub_category_id);



}
