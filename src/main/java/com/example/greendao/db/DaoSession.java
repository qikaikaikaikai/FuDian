package com.example.greendao.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.greendao.db.Useinfo;

import com.example.greendao.db.UseinfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig useinfoDaoConfig;

    private final UseinfoDao useinfoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        useinfoDaoConfig = daoConfigMap.get(UseinfoDao.class).clone();
        useinfoDaoConfig.initIdentityScope(type);

        useinfoDao = new UseinfoDao(useinfoDaoConfig, this);

        registerDao(Useinfo.class, useinfoDao);
    }
    
    public void clear() {
        useinfoDaoConfig.clearIdentityScope();
    }

    public UseinfoDao getUseinfoDao() {
        return useinfoDao;
    }

}
