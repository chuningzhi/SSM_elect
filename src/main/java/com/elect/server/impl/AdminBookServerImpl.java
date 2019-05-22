package com.elect.server.impl;

import com.elect.dao.AdminDao;
import com.elect.dao.BookDao;
import com.elect.dao.CategoryDao;
import com.elect.dao.ProductDao;
import com.elect.entity.Book;
import com.elect.entity.Product;
import com.elect.server.AdminBookServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adminBookServer")
public class AdminBookServerImpl implements AdminBookServer {
    @Resource(name = "adminDao")
    private AdminDao adminDao;
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    @Resource(name = "productDao")
    private ProductDao productDao;
    @Resource(name = "bookDao")
    private BookDao bookDao;

    @Override
    public void updateProduct(Product product, List<Integer> cids) {
        productDao.updateProduct(product);
        bookDao.updateBook(product.getBook());
        categoryDao.updateCategoryProduct(product.getId(),cids.get(0),cids.get(1));
        categoryDao.updateCategoryProduct(product.getId(),cids.get(2),cids.get(3));
    }

    @Override
    public void deleteBook(int pid) {
        bookDao.deleteBook(pid);
        productDao.deleteProduct(pid);
        categoryDao.deleteCategoryProduct(pid);
    }

    @Override
    public int addProduct(Product product) {
        long time = System.currentTimeMillis();
        product.setAdd_time(time);
        productDao.addProduct(product);
        return product.getId();
    }

    @Override
    public void insertBook(Book book) {
        long time = System.currentTimeMillis();
        book.setPublish_time(time);
        book.setAuthor_summary("该商家很懒");
        book.setCatalogue("该商家很懒");
        bookDao.addBook(book);
    }

    @Override
    public void addCategoryProduct(int pid, int cid) {
        categoryDao.addCategoryProduct(pid,cid);
    }
}
