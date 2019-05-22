package com.elect.dao;

import com.elect.entity.CategoryProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryProductDao")
public interface CategoryProductDao {

    List<CategoryProduct> findCategoryProductsByCatId(int cat_id) throws Exception;
}
