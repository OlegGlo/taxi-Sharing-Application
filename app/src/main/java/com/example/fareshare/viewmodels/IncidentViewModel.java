package com.example.fareshare.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fareshare.data.IncidentRepository;
import com.example.fareshare.data.entities.Incident;

import java.util.List;

public class IncidentViewModel extends AndroidViewModel {

    IncidentRepository repository;
    LiveData<List<Incident>> incidentList;

    public IncidentViewModel(Application application) {
        super(application);
        repository = new IncidentRepository(application);
        incidentList = repository.getIncidents();
    }

    public LiveData<List<Incident>> getAllIncidents() {
        return incidentList;
    }

    public Incident getByIncidentID(String incidentID) {
        return repository.getByIncidentID(incidentID);
    }

    public void insertIncident(Incident incident) throws Exception {
        repository.insert(incident);
    }

    public void delete(Incident incident) {
        repository.delete(incident);
    }

}
