package com.elect.dao;

import com.elect.entity.Address;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository("addressDao")
public interface AddressDao {
    List<Address> findAddressByUserId(int user_id);

    void addAddress(Address address);
}
