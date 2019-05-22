package com.elect.action.main;

import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Product;
import com.elect.entity.User;
import com.elect.server.MainServer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/main")
@Controller
public class MainAction {
    @Resource(name = "mainServer")
    private MainServer mainServer;

    public MainAction(){
        logger.info(111111111);
    }


    private Logger logger = Logger.getLogger(MainAction.class);



    @RequestMapping("/goCategory.elect")
    public String goCategory(Category category,int page,HttpServletRequest request){
        Category category1 = mainServer.analyzeCategory(category.getId(),category.getParent_id());
        request.setAttribute("category1",category1);
        List<Product> products = mainServer.findProducts(category.getId(),page);
        request.setAttribute("products",products);
        request.setAttribute("cate_id",category.getId());
        request.setAttribute("parent_id",category.getParent_id());
        int totalPage = mainServer.totalPage(category1,category);
        request.setAttribute("page",page);
        request.setAttribute("totalPage",totalPage);
        return "book_list.jsp";
    }


    @RequestMapping("/goMain.elect")
    public String goMain(HttpServletRequest request){
        List<Product> recommendProducts = mainServer.findRecommend();
        request.setAttribute("recommendProducts",recommendProducts);
        List<Product> hotProducts = mainServer.findHot();
        request.setAttribute("hotProducts",hotProducts);
        List<Product> newProducts = mainServer.findHot();
        request.setAttribute("newProducts",newProducts);
        Category category = mainServer.findCategory();
        request.setAttribute("category",category);
        return "main.jsp";
    }

    @RequestMapping("/goBookDetail.elect")
    public String goBookDetail(int book_id,HttpServletRequest request){
        Product product = mainServer.findProductById(book_id);
        request.setAttribute("product",product);
        return "show_product.jsp";

    }


}
