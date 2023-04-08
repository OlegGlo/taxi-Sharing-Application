package com.example.fareshare.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(
        primaryKeys = {"group_id", "customer_id"}
        /* SUGGESTED */
        , foreignKeys = {
        @ForeignKey(
                entity = CarpoolGroup.class,
                parentColumns = "group_id",
                childColumns = "group_id",
                /* SUGGESTED with ForeignKey */
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = CustomerInfo.class,
                parentColumns = "customer_id",
                childColumns = "customer_id",
                /* SUGGESTED with ForeignKey */
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )
}
)
public class GroupMemberCrossRef {

        @ColumnInfo(name = "group_id")
        @NonNull
        public Long groupID;
        @ColumnInfo(index = true, name = "customer_id")
        @NonNull
        public Long customerID;

        public GroupMemberCrossRef(){}

        @Ignore
        public GroupMemberCrossRef(@NonNull Long groupID, @NonNull Long customerID) {
                this.groupID = groupID;
                this.customerID = customerID;
        }
}
