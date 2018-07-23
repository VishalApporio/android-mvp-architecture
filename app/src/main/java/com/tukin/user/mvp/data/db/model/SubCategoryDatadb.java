package com.tukin.user.mvp.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 5/3/2018.
 */

@Entity(nameInDb = "sub_category_data")
public class SubCategoryDatadb {


    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("sub_category_id")
    @Property(nameInDb = "sub_category_id")
    private Long sub_category_id;

    @Expose
    @SerializedName("sub_category_name")
    @Property(nameInDb = "sub_category_name")
    private String sub_category_name;

    @Generated(hash = 1314646935)
    public SubCategoryDatadb(Long id, Long sub_category_id,
            String sub_category_name) {
        this.id = id;
        this.sub_category_id = sub_category_id;
        this.sub_category_name = sub_category_name;
    }

    @Generated(hash = 1635153443)
    public SubCategoryDatadb() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSub_category_id() {
        return this.sub_category_id;
    }

    public void setSub_category_id(Long sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getSub_category_name() {
        return this.sub_category_name;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

}
