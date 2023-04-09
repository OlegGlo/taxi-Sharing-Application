package com.example.fareshare.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fareshare.data.daos.CustomerInfoDao;

import com.example.fareshare.data.entities.CarpoolGroup;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.GroupMemberCrossRef;


@Database(
        version = 2,
        entities = {
            CustomerInfo.class,
            CarpoolGroup.class,
            GroupMemberCrossRef.class}
        )
public abstract class CustomerInfoDB extends RoomDatabase {

    public abstract CustomerInfoDao customerInfoDao();

    public static final String NAME = "CustomerInfoDB";

    public static CustomerInfoDB INSTANCE;

    public static CustomerInfoDB getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (CustomerInfoDB.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CustomerInfoDB.class, NAME).fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            . build();
                }
            }
        }
        return INSTANCE;
    }

}
