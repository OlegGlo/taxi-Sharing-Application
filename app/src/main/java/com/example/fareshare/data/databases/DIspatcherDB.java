package com.example.fareshare.data.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.fareshare.data.daos.DispatcherDao;
import com.example.fareshare.data.entities.Carpool;
import com.example.fareshare.data.entities.Converters;
import com.example.fareshare.data.entities.Offer;
import com.example.fareshare.data.entities.Request;

@Database(version = 2,
        entities = {
            Carpool.class,
            Offer.class,
            Request.class
        })
@TypeConverters(Converters.class)
public abstract class DIspatcherDB extends RoomDatabase {

    public abstract DispatcherDao dispatcherDao();
    public static final String NAME = "DispatcherDAO";
    public static DIspatcherDB INSTANCE;

    public static DIspatcherDB getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (CustomerInfoDB.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DIspatcherDB.class, NAME).fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            . build();
                }
            }
        }
        return INSTANCE;
    }
}
