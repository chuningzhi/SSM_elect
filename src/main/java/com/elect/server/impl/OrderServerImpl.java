package com.elect.server.impl;

import com.elect.dao.AddressDao;
import com.elect.dao.ItemDao;
import com.elect.dao.OrderDao;
import com.elect.entity.Address;
import com.elect.entity.Cart;
import com.elect.entity.Item;
import com.elect.entity.Order;
import com.elect.server.OrderServer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("orderServer")
public class OrderServerImpl implements OrderServer {
    @Resource(name = "orderDao")
    private OrderDao orderDao;
    @Resource(name = "addressDao")
    private AddressDao addressDao;
    @Resource(name = "itemDao")
    private ItemDao itemDao;


    private Logger logger = Logger.getLogger(OrderServerImpl.class);

    @Override
    public List<Item> findItems(List<Cart> carts, int user_id) {
        List<Item> items = new ArrayList<>();
        for (Cart cart :carts){
            if(cart.getIsdele().equals("N")){
                Item item = new Item();
                item.setProduct_id(cart.getProduct_id());
                item.setProduct_name(cart.getProduct().getProduct_name());
                item.setDang_price(cart.getProduct().getDang_price());
                item.setProduct_num(cart.getProduct_num());
                item.setAmount(item.getDang_price()*item.getProduct_num());
                items.add(item);
            }
        }
//        itemDao.addItems(items);
        return items;
    }

    @Override
    public List<Address> findAddress(int user_id) {
        List<Address> addressList = addressDao.findAddressByUserId(user_id);
        return addressList;
    }

    @Override
    public Order addOrder(Order order, List<Item> items, int flag) {
        order.setOrder_time(System.currentTimeMillis());
        order.setStatus(1);
        double totalPrice = 0;
        for (Item item : items){
            totalPrice +=item.getDang_price()*item.getProduct_num();
        }
        order.setTotal_price(totalPrice);
        orderDao.addOrder(order);
        logger.info(order);
        for (Item item : items){
            item.setOrder_id(order.getId());
            itemDao.addItems(item);
        }
        if(flag == 0) {
            Address address = new Address();
            address.setReceive_name(order.getReceive_name());
            address.setMobile(order.getMobile());
            address.setPhone(order.getPhone());
            address.setPostal_code(order.getPostal_code());
            address.setFull_address(order.getFull_address());
            address.setUser_id(order.getUser_id());
            addressDao.addAddress(address);
        }
        return order;
    }
}
