package com.apporio.ubereats.mvp.di.others.events;

/**
 * Created by lenovo on 5/2/2018.
 */

public class GetAllProductInformationEvent {

    public Integer selector_id;
    public String selector_name,selector_availability,selector_price;

    public GetAllProductInformationEvent(Integer selector_id, String selector_name,String selector_availability,String selector_price) {
        this.selector_id = selector_id;
        this.selector_name = selector_name;
        this.selector_availability = selector_availability;
        this.selector_price = selector_price;
    }

    public String getSelector_availability() {
        return selector_availability;
    }

    public void setSelector_availability(String selector_availability) {
        this.selector_availability = selector_availability;
    }

    public String getSelector_price() {
        return selector_price;
    }

    public void setSelector_price(String selector_price) {
        this.selector_price = selector_price;
    }

    public Integer getSelector_id() {
        return selector_id;
    }

    public void setSelector_id(Integer selector_id) {
        this.selector_id = selector_id;
    }

    public String getSelector_name() {
        return selector_name;
    }

    public void setSelector_name(String selector_name) {
        this.selector_name = selector_name;
    }
}
