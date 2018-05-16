

package com.apporio.ubereats.mvp.data.db;

import com.apporio.ubereats.mvp.data.db.model.Option;
import com.apporio.ubereats.mvp.data.db.model.ProductDatadb;
import com.apporio.ubereats.mvp.data.db.model.Question;
import com.apporio.ubereats.mvp.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by vishal@apporio.com on 08/12/16.
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

    Observable<Long> insertProduct(final ProductDatadb productDatadb);
}
