

package com.tukin.user.mvp.data.db;

import android.content.Context;

import com.tukin.user.mvp.data.db.model.DaoMaster;
import com.tukin.user.mvp.data.db.model.ProductDatadbDao;
import com.tukin.user.mvp.di.ApplicationContext;
import com.tukin.user.mvp.di.DatabaseInfo;
import com.tukin.user.mvp.utils.AppLogger;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        AppLogger.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
        switch (oldVersion) {
            case 1:
            case 2:
//                db.execSQL("CREATE TABLE " + ProductDatadbDao.TABLENAME + " ADD COLUMN "
//                        + ProductDatadbDao.Properties.Product_name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
        }
    }
}
