package com.example.fareshare.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "Incidents",
        indices = {@Index(value = "incident_id", unique = true)})
public class Incident {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "incident_id")
    private String incidentID;
    @NonNull
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "report")
    private String report;

    public Incident(@NonNull String email, String report) {
        this.email = email;
        this.report = report;
        this.incidentID = UUID.randomUUID().toString();
    }
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIncidentID() { return incidentID; }

    public void setIncidentID(String incidentID) {
        this.incidentID = incidentID;
    }
}