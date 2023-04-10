package com.example.fareshare.data.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.fareshare.data.daos.CustomerInfoDao;

import com.example.fareshare.data.entities.CarpoolGroup;
import com.example.fareshare.data.entities.Converters;
import com.example.fareshare.data.entities.CustomerInfo;


@Database(
        version = 4,
        entities = {
            CustomerInfo.class,
            CarpoolGroup.class}
        )
@TypeConverters(Converters.class)
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
