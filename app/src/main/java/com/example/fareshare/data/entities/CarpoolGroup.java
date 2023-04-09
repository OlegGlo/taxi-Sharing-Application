package com.example.fareshare.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class CarpoolGroup {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "group_id")
    private Long groupID;
    @ColumnInfo(name = "group_name")
    private String groupName;
    @ColumnInfo(name = "leader_id")
    private Long leaderID;
    @ColumnInfo(name = "members")
    private ArrayList<CustomerInfo> members;

    public CarpoolGroup(){}

    @Ignore
    public CarpoolGroup(String groupName, Long leaderID, ArrayList<CustomerInfo> members) {
        this.groupName = groupName;
        this.leaderID = leaderID;
        this.members = members;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<CustomerInfo> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<CustomerInfo> members) {
        this.members = members;
    }

    public Long getLeaderID() {
        return leaderID;
    }

    public void setLeaderID(Long leaderID) {
        this.leaderID = leaderID;
    }
}
