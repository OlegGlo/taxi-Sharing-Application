package com.example.fareshare.data.entities.wrappers;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.fareshare.data.entities.CarpoolGroup;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.GroupMemberCrossRef;

import java.util.List;

public class GroupWithMembers {

    @Embedded
    private CarpoolGroup carpoolGroup;
    @Relation(
            parentColumn = "group_id",
            entityColumn = "customer_id",
            associateBy = @Junction(GroupMemberCrossRef.class)
    )

    private List<CustomerInfo> customerList;

    public GroupWithMembers(){}

    @Ignore
    public GroupWithMembers(CarpoolGroup carpoolGroup, List<CustomerInfo> customerList) {
        this.carpoolGroup = carpoolGroup;
        this.customerList = customerList;
    }

    public CarpoolGroup getCard() {
        return carpoolGroup;
    }

    public void setCarpoolGroup(CarpoolGroup carpoolGroup) {
        this.carpoolGroup = carpoolGroup;
    }

    public List<CustomerInfo> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerInfo> customerList) {
        this.customerList = customerList;
    }
}
