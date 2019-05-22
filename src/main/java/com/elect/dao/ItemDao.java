package com.elect.dao;

import com.elect.entity.Item;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("itemDao")
public interface ItemDao {
    void addItems(Item item);
}
