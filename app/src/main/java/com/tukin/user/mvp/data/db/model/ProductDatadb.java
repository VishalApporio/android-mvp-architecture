package com.tukin.user.mvp.data.db.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by lenovo on 4/28/2018.
 */

@Entity(nameInDb = "product_data")
public class ProductDatadb {

    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("category_id")
    @Property(nameInDb = "category_id")
    private String category_id;

    @Expose
    @SerializedName("subb_category_id")
    @Property(nameInDb = "subb_category_id")
    private String subb_category_id;

    @Expose
    @SerializedName("product_id")
    @Property(nameInDb = "product_id")
    private Integer product_id;

    @Expose
    @SerializedName("product_name")
    @Property(nameInDb = "product_name")
    private String product_name;

    @Expose
    @SerializedName("product_price")
    @Property(nameInDb = "product_price")
    private String product_price;

    @Expose
    @SerializedName("product_price_per_unit")
    @Property(nameInDb = "product_price_per_unit")
    private String product_price_per_unit;

    @Expose
    @SerializedName("product_quantity")
    @Property(nameInDb = "product_quantity")
    private Integer product_quantity;

    @Expose
    @SerializedName("total_price")
    @Property(nameInDb = "total_price")
    private Integer total_price;

    @Generated(hash = 1787499614)
    public ProductDatadb(Long id, String category_id, String subb_category_id,
            Integer product_id, String product_name, String product_price,
            String product_price_per_unit, Integer product_quantity, Integer total_price) {
        this.id = id;
        this.category_id = category_id;
        this.subb_category_id = subb_category_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_price_per_unit = product_price_per_unit;
        this.product_quantity = product_quantity;
        this.total_price = total_price;
    }

    @Generated(hash = 1155929787)
    public ProductDatadb() {
    }


    public Integer getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return this.product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_price_per_unit() {
        return this.product_price_per_unit;
    }

    public void setProduct_price_per_unit(String product_price_per_unit) {
        this.product_price_per_unit = product_price_per_unit;
    }

    public Integer getProduct_quantity() {
        return this.product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }

    public Integer getTotal_price() {
        return this.total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSubb_category_id() {
        return this.subb_category_id;
    }

    public void setSubb_category_id(String subb_category_id) {
        this.subb_category_id = subb_category_id;
    }
}
