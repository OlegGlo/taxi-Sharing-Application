package com.example.fareshare.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class CarpoolGroup {

    @PrimaryKey
    @ColumnInfo(name = "group_id")
    private Long groupID;
    @ColumnInfo(name = "group_name")
    private String groupName;
    @ColumnInfo(name = "leader_id")
    private Long leaderID;

    public CarpoolGroup(){}

    @Ignore
    public CarpoolGroup(String groupName, Long leaderID) {
        this.groupName = groupName;
        this.leaderID = leaderID;
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

    public Long getLeaderID() {
        return leaderID;
    }

    public void setLeaderID(Long leaderID) {
        this.leaderID = leaderID;
    }
}
