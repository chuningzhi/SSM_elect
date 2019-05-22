package com.elect.server;

import com.elect.entity.Address;
import com.elect.entity.Cart;
import com.elect.entity.Item;
import com.elect.entity.Order;

import java.util.List;

public interface OrderServer {
    List<Item> findItems(List<Cart> carts, int user_id);

    List<Address> findAddress(int user_id);

    Order addOrder(Order order, List<Item> items, int flag);
}
