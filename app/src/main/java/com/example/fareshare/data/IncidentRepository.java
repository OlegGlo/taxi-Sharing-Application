package com.example.fareshare.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.fareshare.data.daos.IncidentDao;
import com.example.fareshare.data.databases.IncidentDB;
import com.example.fareshare.data.entities.Incident;

import java.util.List;

public class IncidentRepository {

    private IncidentDao incidentDao;
    private LiveData<List<Incident>> allIncidents;

    public IncidentRepository(Application application) {
        IncidentDB db = IncidentDB.getDatabase(application);
        incidentDao = db.incidentDao();
        allIncidents = incidentDao.getAllIncidents();
    }

    public LiveData<List<Incident>> getIncidents() {
        return allIncidents;
    }

    public Incident getByIncidentID(String incidentID){
        return incidentDao.getByIncidentID(incidentID);
    }

    public void insert(Incident incident) throws Exception {
        incidentDao.addIncident(incident);
    }
    public void delete(Incident incident) {
        incidentDao.delete(incident);
    }
}
