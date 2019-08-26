package com.gykj.zhumulangma.common.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.gykj.zhumulangma.common.bean.TrackDownloadBean.DownloadStateConverter;
import com.ximalaya.ting.android.sdkdownloader.downloadutil.DownloadState;

import com.gykj.zhumulangma.common.bean.TrackDownloadBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TRACK_DOWNLOAD_BEAN".
*/
public class TrackDownloadBeanDao extends AbstractDao<TrackDownloadBean, Long> {

    public static final String TABLENAME = "TRACK_DOWNLOAD_BEAN";

    /**
     * Properties of entity TrackDownloadBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property TrackId = new Property(0, long.class, "trackId", true, "_id");
        public final static Property Status = new Property(1, Integer.class, "status", false, "STATUS");
    }

    private final DownloadStateConverter statusConverter = new DownloadStateConverter();

    public TrackDownloadBeanDao(DaoConfig config) {
        super(config);
    }
    
    public TrackDownloadBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TRACK_DOWNLOAD_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: trackId
                "\"STATUS\" INTEGER);"); // 1: status
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TRACK_DOWNLOAD_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TrackDownloadBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getTrackId());
 
        DownloadState status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(2, statusConverter.convertToDatabaseValue(status));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TrackDownloadBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getTrackId());
 
        DownloadState status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(2, statusConverter.convertToDatabaseValue(status));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public TrackDownloadBean readEntity(Cursor cursor, int offset) {
        TrackDownloadBean entity = new TrackDownloadBean( //
            cursor.getLong(offset + 0), // trackId
            cursor.isNull(offset + 1) ? null : statusConverter.convertToEntityProperty(cursor.getInt(offset + 1)) // status
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TrackDownloadBean entity, int offset) {
        entity.setTrackId(cursor.getLong(offset + 0));
        entity.setStatus(cursor.isNull(offset + 1) ? null : statusConverter.convertToEntityProperty(cursor.getInt(offset + 1)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TrackDownloadBean entity, long rowId) {
        entity.setTrackId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TrackDownloadBean entity) {
        if(entity != null) {
            return entity.getTrackId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TrackDownloadBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}