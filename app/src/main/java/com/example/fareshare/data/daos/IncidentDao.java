package com.example.fareshare.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fareshare.data.entities.Incident;

import java.util.List;

@Dao
public interface IncidentDao {

    @Query("SELECT * FROM Incidents")
    LiveData<List<Incident>> getAllIncidents();

    @Query("SELECT * FROM INCIDENTS WHERE incident_id LIKE :incidentID")
    Incident getByIncidentID(String incidentID);
    @Insert(entity = Incident.class)
    long addIncident(Incident incident) throws Exception;

    @Delete
    void delete(Incident incident);

}
