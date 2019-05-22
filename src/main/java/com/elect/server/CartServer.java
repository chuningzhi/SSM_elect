package com.elect.server;

import com.elect.entity.Cart;

import java.util.List;

public interface CartServer {
    List<Cart> findCartByUserId(int user_id);

    String countTotalPrice(List<Cart> carts);

    String countEconomyPrice(List<Cart> carts);

    Boolean addCart(int product_id, int user_id);

    void changeCartNumById(int cart_id, int inputNum);

    void cartUpdateIsdele(int cart_id, String flag);

    void deleCart(int user_id);
}
