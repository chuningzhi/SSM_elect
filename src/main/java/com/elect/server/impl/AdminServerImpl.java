package com.elect.server.impl;

import com.elect.dao.AdminDao;
import com.elect.dao.BookDao;
import com.elect.dao.CategoryDao;
import com.elect.dao.ProductDao;
import com.elect.entity.Admin;
import com.elect.entity.Category;
import com.elect.entity.Product;
import com.elect.server.AdminServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminServer")
public class AdminServerImpl implements AdminServer {
    @Resource(name = "adminDao")
    private AdminDao adminDao;
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    @Resource(name = "productDao")
    private ProductDao productDao;
    @Resource(name = "bookDao")
    private BookDao bookDao;

    @Override
    public Admin login(Admin admin) {
        admin = adminDao.login(admin);
        return admin;
    }

    @Override
    public List<Category> findCategorysById(int id) {
        List<Category> categories = categoryDao.findCategorysByParentId(id);
        return categories;
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> products= null;
        try {
            products = productDao.findAllProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findProductByid(int pid) {
        Product product = productDao.findProductById(pid);
        return product;
    }

    @Override
    public Map<String, Integer> judgeCate(List<Integer> cateIds, Category category) {
        Map<String,Integer> map = new HashMap<>();
        for (Integer i : cateIds){
            if(category.getId() == i){
                map.put("0",i);
                continue;
            }else{
                for (Category category1 : category.getCategories()){
                    if(category1.getId()==i){
                        map.put("1",i);
                        continue;
                    }else {
                        for (Category category2 : category1.getCategories()){
                            if(category2.getId() == i){
                                map.put("2",i);
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    @Override
    public List<Integer> findCateIdByProductId(int pid) {
        List<Integer> integers = categoryDao.findCateIdsByProductId(pid);
        return integers;
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Override
    public Category findCategoryById(int cid) {
        Category category = categoryDao.findCateById(cid);
        return category;
    }

    @Override
    public void deleteCategory(int cid) {
        categoryDao.deleteCategory(cid);
        categoryDao.deleteCategoryProductByCategoryId(cid);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }
}
