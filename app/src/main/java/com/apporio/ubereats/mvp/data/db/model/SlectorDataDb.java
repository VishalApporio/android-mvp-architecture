package com.apporio.ubereats.mvp.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 4/28/2018.
 */

@Entity(nameInDb = "selector_data")
public class SlectorDataDb {


    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "selector_id")
    private Long selector_id;

    @Property(nameInDb = "selector_product_id")
    private Integer selector_product_id;

    @Property(nameInDb = "selector_price")
    private String selector_price;

    @Property(nameInDb = "created_at")
    private String createdAt;

    @Property(nameInDb = "updated_at")
    private String updatedAt;

    @Generated(hash = 1183451199)
    public SlectorDataDb(Long id, Long selector_id, Integer selector_product_id,
            String selector_price, String createdAt, String updatedAt) {
        this.id = id;
        this.selector_id = selector_id;
        this.selector_product_id = selector_product_id;
        this.selector_price = selector_price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Generated(hash = 2014094306)
    public SlectorDataDb() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSelector_product_id() {
        return this.selector_product_id;
    }

    public void setSelector_product_id(Integer selector_product_id) {
        this.selector_product_id = selector_product_id;
    }

    public String getSelector_price() {
        return this.selector_price;
    }

    public void setSelector_price(String selector_price) {
        this.selector_price = selector_price;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getSelector_id() {
        return this.selector_id;
    }

    public void setSelector_id(Long selector_id) {
        this.selector_id = selector_id;
    }


}
