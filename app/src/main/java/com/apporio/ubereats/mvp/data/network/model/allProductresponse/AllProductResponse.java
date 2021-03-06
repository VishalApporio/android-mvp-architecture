
package com.apporio.ubereats.mvp.data.network.model.allProductresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllProductResponse {

    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response")
    @Expose
    private Response response;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
