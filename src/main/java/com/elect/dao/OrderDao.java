package com.elect.dao;

import com.elect.entity.Order;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("orderDao")
public interface OrderDao {
    void addOrder(Order order);
}
