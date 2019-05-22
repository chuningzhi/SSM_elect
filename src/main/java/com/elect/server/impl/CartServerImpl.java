package com.elect.server.impl;

import com.elect.dao.BookDao;
import com.elect.dao.CartDao;
import com.elect.dao.CategoryDao;
import com.elect.dao.ProductDao;
import com.elect.entity.Cart;
import com.elect.entity.Product;
import com.elect.server.CartServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service("cartServer")
public class CartServerImpl implements CartServer {
    @Resource(name = "bookDao")
    private BookDao bookDao;
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    @Resource(name = "productDao")
    private ProductDao productDao;
    @Resource(name = "cartDao")
    private CartDao cartDao;


    @Override
    public List<Cart> findCartByUserId(int user_id) {
        List<Cart> carts = new ArrayList<>();
        carts = cartDao.findCartByUserID(user_id);
        for (Cart cart : carts) {
            Product product = productDao.findProductById(cart.getProduct_id());
            cart.setProduct(product);
        }
        return carts;
    }

    @Override
    public String countTotalPrice(List<Cart> carts) {
        double totalPrice = 0;
        for (Cart c :carts){
            if(c.getIsdele().equals("N")) {
                totalPrice += c.getProduct().getDang_price() * c.getProduct_num();
            }
        }
        DecimalFormat df =new DecimalFormat("0.00");
        String str_totalPrice = df.format(totalPrice);
        return str_totalPrice;
    }

    @Override
    public String countEconomyPrice(List<Cart> carts) {
        double economyPrice = 0;
        for (Cart c:carts){
            if(c.getIsdele().equals("N")) {
                economyPrice += (c.getProduct().getFixed_price() - c.getProduct().getDang_price()) * c.getProduct_num();
            }
        }
        DecimalFormat df =new DecimalFormat("0.00");
        String str_economyPrice = df.format(economyPrice);
        return str_economyPrice;
    }

    @Override
    public Boolean addCart(int product_id, int user_id) {
        try {
            List<Cart> carts = findCartByUserId(user_id);
            for (Cart cart :carts){
                if(cart.getProduct().getId() == product_id){
                    return false;
                }
            }
            cartDao.addCart(product_id, user_id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void changeCartNumById(int cart_id, int inputNum) {
        cartDao.changeCartNumById(cart_id,inputNum);
    }

    @Override
    public void cartUpdateIsdele(int cart_id, String flag) {
        cartDao.updateCartIsdeleById(cart_id,flag);
    }

    @Override
    public void deleCart(int user_id) {
        cartDao.deleCartByUserId(user_id);
    }
}
