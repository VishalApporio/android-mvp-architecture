
package com.apporio.ubereats.mvp.data.network.model.allProductresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestauranentStyle {

    @SerializedName("style_id")
    @Expose
    private Integer styleId;
    @SerializedName("style_name")
    @Expose
    private String styleName;

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

}
