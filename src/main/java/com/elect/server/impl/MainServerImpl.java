package com.elect.server.impl;

import com.elect.dao.BookDao;
import com.elect.dao.CategoryDao;
import com.elect.dao.ProductDao;
import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Product;
import com.elect.server.MainServer;
import com.elect.utils.ConfigUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("mainServer")
public class MainServerImpl implements MainServer {
    @Resource(name = "bookDao")
    private BookDao bookDao;
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    @Resource(name = "productDao")
    private ProductDao productDao;
    @Resource(name = "configUtil")
    private ConfigUtil configUtil;

    private Logger logger = Logger.getLogger(MainServerImpl.class);

    Random ran = new Random();

    @Override
    public List<Product> findRecommend() {
        List<Product> recommendProducts = new ArrayList<>();
        for (int i = 0; i < 2 ; ) {
            int ranInt = ran.nextInt(30);
            Product product = null;
            try {
                product = productDao.findProductById(ranInt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(product != null){
                if(!recommendProducts.contains(product)) {
                    i++;
                    recommendProducts.add(product);
                }
            }
        }
        return recommendProducts;
    }

    @Override
    public List<Product> findHot() {
        List<Product> hotProducts = new ArrayList<>();
        for (int i = 0; i < 4 ; ) {
            int j = ran.nextInt(23)+1;
            Product product = productDao.findProductById(j);
            if(!hotProducts.contains(product)) {
                i++;
                hotProducts.add(product);
            }
        }
        return hotProducts;
    }

    @Override
    public Category findCategory() {
        Category category = categoryDao.findCategoryByParentId(0);
        return category;
    }

    @Override
    public Category analyzeCategory(int id, int parent_id) {
        Category category = this.findCategory();
        for (Category category1 : category.getCategories()){
            if(parent_id == 1){
                if(category1.getId() == id){
                    return category1;
                }
            }else {
                if(category1.getId() == parent_id){
                    return category1;
                }
            }
        }
        return category;
    }

    @Override
    public List<Product> findProducts(int id, int page) {
        List<Product> products = null;
        int pageSize = Integer.parseInt(configUtil.getValue(ConfigUtil.PAGE_PRO,"pageSize"));
        products = productDao.findProducts(id,(page-1)*pageSize,pageSize);
        for (Product product: products){
            logger.info(product);
        }
        return products;
    }

    @Override
    public int totalPage(Category category1, Category category) {
        int totalPage = -1;
        int pageSize = Integer.parseInt(configUtil.getValue(ConfigUtil.PAGE_PRO,"pageSize"));
        if(category1.getId() == category.getId()){
            if (category1.getCategoryProducts().size()%pageSize == 0 ) {
                totalPage = category1.getCategoryProducts().size() / pageSize;
            }else {
                totalPage = category1.getCategoryProducts().size() / pageSize + 1;
            }
        }else {
            for (Category c :category1.getCategories()){
                if(c.getId() == category.getId()){
                    logger.info(c);
                    logger.info(c.getCategories());
                    if(c.getCategoryProducts().size()%pageSize == 0 ) {
                        totalPage = c.getCategoryProducts().size() / pageSize;
                    }else {
                        totalPage = c.getCategoryProducts().size() / pageSize + 1;
                    }
                }
            }
        }
        return totalPage;
    }

    @Override
    public Product findProductById(int book_id) {
        Product product = productDao.findProductById(book_id);
        return product;
    }

}
