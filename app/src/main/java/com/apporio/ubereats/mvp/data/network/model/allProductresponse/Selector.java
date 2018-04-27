
package com.apporio.ubereats.mvp.data.network.model.allProductresponse;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Selector implements Serializable {

    @SerializedName("selector_type")
    @Expose
    private String selectorType;
    @SerializedName("selector_name")
    @Expose
    private String selectorName;
    @SerializedName("mandatory")
    @Expose
    private Boolean mandatory;
    @SerializedName("selector_data")
    @Expose
    private List<SelectorDatum> selectorData = null;

    public String getSelectorType() {
        return selectorType;
    }

    public void setSelectorType(String selectorType) {
        this.selectorType = selectorType;
    }

    public String getSelectorName() {
        return selectorName;
    }

    public void setSelectorName(String selectorName) {
        this.selectorName = selectorName;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public List<SelectorDatum> getSelectorData() {
        return selectorData;
    }

    public void setSelectorData(List<SelectorDatum> selectorData) {
        this.selectorData = selectorData;
    }

}
