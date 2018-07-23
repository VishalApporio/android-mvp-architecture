package com.tukin.user.mvp.data.db.model;

/**
 * Created by lenovo on 5/5/2018.
 */

public class CheckOutResponse {


    /**
     * result : 1
     * message : Cart Updated Succesfullt
     */

    private int result;
    private String message;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
