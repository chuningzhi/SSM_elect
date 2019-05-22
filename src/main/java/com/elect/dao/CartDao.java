package com.elect.dao;

import com.elect.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("cartDao")
public interface CartDao {
    void addCart(@Param("product_id") int product_id,@Param("user_id") int user_id);

    List<Cart> findCartByUserID(int user_id);

    void changeCartNumById(@Param("id") int cart_id,@Param("product_num") int inputNum);

    void updateCartIsdeleById(@Param("id") int cart_id,@Param("flag") String flag);

    void deleCartByUserId(int user_id);
}
