package com.tukin.user.mvp.data.network.model;

/**
 * Created by lenovo on 5/17/2018.
 */

public class UpdateDeviceIdResponse {


    /**
     * result : 1
     * msg : Device Id Updated!!
     */

    private int result;
    private String msg;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
