package com.elect.dao;

import com.elect.entity.Category;
import com.elect.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {

    List<Category> findCategorysByParentId(int parent_id);

    Category findCategoryByParentId(int id);

    Category findCateById(int id);

    List<Integer> findCateIdsByProductId(int pid);

    void addCategory(Category category);

    void deleteCategory(int cid);

    void deleteCategoryProductByCategoryId(int cid);

    void updateCategory(Category category);

    void updateCategoryProduct(@Param("pid") int pid,@Param("newCid") Integer integer,@Param("oldCid") Integer integer1);

    void deleteCategoryProduct(int pid);

    void addCategoryProduct(@Param("pid") int pid,@Param("cid") int cid);
}
