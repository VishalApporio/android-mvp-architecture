package com.tukin.user.mvp.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;

/**
 * Created by lenovo on 5/3/2018.
 */

@Entity(nameInDb = "category_data")
public class CategoryDatadb {


    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("category_id")
    @Property(nameInDb = "category_id")
    private Integer category_id;

    @Expose
    @SerializedName("category_name")
    @Property(nameInDb = "category_name")
    private String category_name;

    @ToMany(referencedJoinProperty = "sub_category_id")
    private List<SubCategoryDatadb> sub_category_id;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1119550727)
    private transient CategoryDatadbDao myDao;

    @Generated(hash = 1638575648)
    public CategoryDatadb(Long id, Integer category_id, String category_name) {
        this.id = id;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    @Generated(hash = 1201005680)
    public CategoryDatadb() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 508479892)
    public List<SubCategoryDatadb> getSub_category_id() {
        if (sub_category_id == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SubCategoryDatadbDao targetDao = daoSession.getSubCategoryDatadbDao();
            List<SubCategoryDatadb> sub_category_idNew = targetDao
                    ._queryCategoryDatadb_Sub_category_id(id);
            synchronized (this) {
                if (sub_category_id == null) {
                    sub_category_id = sub_category_idNew;
                }
            }
        }
        return sub_category_id;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 36036951)
    public synchronized void resetSub_category_id() {
        sub_category_id = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 993472931)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCategoryDatadbDao() : null;
    }

}
