package com.example.fareshare.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.fareshare.data.entities.CarpoolGroup;
import com.example.fareshare.data.entities.CustomerIdentity;
import com.example.fareshare.data.entities.CustomerInfo;
import com.example.fareshare.data.entities.GroupMemberCrossRef;
import com.example.fareshare.data.entities.wrappers.FullName;
import com.example.fareshare.data.entities.wrappers.GroupWithMembers;

import java.util.List;

@Dao
public abstract class CustomerInfoDao {

    //CUSTOMER STUFF
    @Query("SELECT * FROM Customers")
    public abstract LiveData<List<CustomerInfo>> getAllCustomers();

    @Query("SELECT email, password FROM Customers WHERE email LIKE :customerEmail")
    public abstract CustomerIdentity getVerificationInfo(String customerEmail);

    @Query("SELECT * FROM CUSTOMERS WHERE customer_id LIKE :customerID")
    public abstract CustomerInfo getByID(Long customerID);

    @Query("SELECT * FROM CUSTOMERS WHERE email LIKE :customerEmail")
    public abstract CustomerInfo getByEmail(String customerEmail);

    @Query("SELECT * FROM CUSTOMERS WHERE phone_number LIKE :phoneNumber")
    public abstract CustomerInfo getByPhoneNumber(String phoneNumber);

    @Query("SELECT first_name, last_name FROM Customers WHERE email LIKE :customerEmail")
    public abstract FullName getFullName(String customerEmail);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public abstract void insertAll(CustomerInfo...customerInfos) throws Exception;

    @Insert
    public abstract long addCustomer(CustomerInfo customerInfo) throws Exception;

    @Delete
    public abstract void delete(CustomerInfo customerInfo);

    //GROUP STUFF
    @Insert
    public abstract long addGroup(CarpoolGroup carpoolGroup);
    @Delete
    public abstract void delete(CarpoolGroup carpoolGroup);

    //JOIN STUFF
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertGroupWithMembers(GroupMemberCrossRef groupMemberCrossRef);

    @Query("")
    @Transaction
    public long[] insert(CarpoolGroup carpoolGroup, List<CustomerInfo> customers) throws Exception{
        long[] rv = new long[customers.size() + 1];
        int ix = 0;
        rv[ix++] = addGroup(carpoolGroup);
        if (rv[ix-1] > -1) {
            for (CustomerInfo c : customers) {
                rv[ix++] = addCustomer(c);
                if (rv[ix-1] > -1) {
                    insertGroupWithMembers(new GroupMemberCrossRef(rv[0],rv[ix-1]));
                }
            }

        }
        return rv;
    }

    @Transaction
    @Query("SELECT * FROM CarpoolGroup")
    public abstract LiveData<List<GroupWithMembers>> getAllCards();
}
