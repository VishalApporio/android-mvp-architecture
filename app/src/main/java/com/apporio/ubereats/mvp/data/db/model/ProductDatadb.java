package com.apporio.ubereats.mvp.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;

/**
 * Created by lenovo on 4/28/2018.
 */

@Entity(nameInDb = "product_data")
public class ProductDatadb {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "product_id")
    private Integer product_id;

    @Property(nameInDb = "product_name")
    private String product_name;

    @Property(nameInDb = "product_price")
    private String product_price;

    @Property(nameInDb = "product_price_per_unit")
    private String product_price_per_unit;

    @Property(nameInDb = "product_quantity")
    private Integer product_quantity;

    @ToMany(referencedJoinProperty = "selector_id")
    private List<SlectorDataDb> selectorId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1405564652)
    private transient ProductDatadbDao myDao;
    
    @Generated(hash = 759396155)
    public ProductDatadb(Long id, Integer product_id, String product_name,
                         String product_price, String product_price_per_unit,
                         Integer product_quantity) {
        this.id = id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_price_per_unit = product_price_per_unit;
        this.product_quantity = product_quantity;
    }

    @Generated(hash = 1155929787)
    public ProductDatadb() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 923402123)
    public List<SlectorDataDb> getSelectorId() {
        if (selectorId == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SlectorDataDbDao targetDao = daoSession.getSlectorDataDbDao();
            List<SlectorDataDb> selectorIdNew = targetDao
                    ._queryProductDatadb_SelectorId(id);
            synchronized (this) {
                if (selectorId == null) {
                    selectorId = selectorIdNew;
                }
            }
        }
        return selectorId;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1715949111)
    public synchronized void resetSelectorId() {
        selectorId = null;
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
    @Generated(hash = 2023969996)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProductDatadbDao() : null;
    }
}
