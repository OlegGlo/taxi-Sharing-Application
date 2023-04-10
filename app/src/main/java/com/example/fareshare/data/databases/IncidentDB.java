package com.example.fareshare.data.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.fareshare.data.daos.IncidentDao;

import com.example.fareshare.data.entities.Incident;
import com.example.fareshare.data.entities.Converters;


@Database(
        entities = {
                Incident.class
        }
)
public abstract class IncidentDB extends RoomDatabase {

    public abstract IncidentDao incidentDao();
    public static final String NAME = "IncidentDB";

    public static IncidentDB INSTANCE;

    public static IncidentDB getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (IncidentDB.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    IncidentDB.class, NAME).fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            . build();
                }
            }
        }
        return INSTANCE;
    }

}