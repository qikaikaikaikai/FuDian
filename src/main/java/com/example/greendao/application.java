package com.example.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendao.db.DaoMaster;
import com.example.greendao.db.DaoSession;

public class application extends Application {
    public  static  application application;
    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper qikaikai_db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
application=this;
setdate();
    }

    private void setdate() {
        //类名.方法名调取里面的数据库

        qikaikai_db = new DaoMaster.DevOpenHelper(this, "qikaikai_db", null);
        db = qikaikai_db.getWritableDatabase();
        //链接数据库
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public  static  application getApplication(){
        return  application;
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
