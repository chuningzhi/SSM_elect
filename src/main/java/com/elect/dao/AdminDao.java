package com.elect.dao;

import com.elect.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public interface AdminDao {

    Admin login(Admin admin);
}
