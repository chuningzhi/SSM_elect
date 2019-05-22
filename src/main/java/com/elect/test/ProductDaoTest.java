package com.elect.test;

import com.elect.dao.*;
import com.elect.entity.*;
import com.elect.server.MainServer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductDaoTest {

    @Test
    public void test() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

        OrderDao orderDao = ac.getBean("orderDao",OrderDao.class);
        Order order = new Order();
        order.setUser_id(1);
        order.setStatus(1);
        order.setOrder_time(System.currentTimeMillis());
        order.setTotal_price(10);
        orderDao.addOrder(order);
        System.out.println(order);



        /*ProductDao productDao = (ProductDao) ac.getBean("productDao");
        List<Product> products = productDao.findProducts(1, 0, 3);
        for (Product product :products){
            System.out.println(product);
        }*/


        /*MainServer mainServer = (MainServer) ac.getBean("mainServer");
        List<Product> products1 = mainServer.findProducts(1, 1);
        System.out.println(products1);*/

       /* Product product1 = productDao.findProductById(1);
        System.out.println(product1);
        BookDao bookDao = (BookDao) ac.getBean("bookDao");
        Book book = bookDao.findBookById(1);
        System.out.println(book);*/
        /*MainServer mainServer = (MainServer) ac.getBean("mainServer");
        List<Product> recommend = mainServer.findRecommend();
        for (Product product : recommend){
            System.out.println(product);
        }*/


        /*CategoryDao categoryDao = (CategoryDao) ac.getBean("categoryDao");
        Category category = categoryDao.findCategoryByParentId(0);
//        System.out.println(category);
        for (Category category1 : category.getCategories()) {
            System.out.println(category1);
            System.out.println(category1.getCategories());
        }*/


       /*UserDao userDao = (UserDao) ac.getBean("userDao");
        User user = new User();
        user.setEmail("956@qq.com");
        user.setPassword("1111");
        int id = userDao.addUser(user);
        System.out.println(user);*/
    }
    }

