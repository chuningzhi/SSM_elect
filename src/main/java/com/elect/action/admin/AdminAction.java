package com.elect.action.admin;

import com.elect.entity.Admin;
import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Product;
import com.elect.server.AdminServer;
import com.elect.server.MainServer;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class AdminAction {
    @Resource(name = "adminServer")
    private AdminServer adminServer;
    @Resource(name = "mainServer")
    private MainServer mainServer;


    private Logger logger = Logger.getLogger(AdminAction.class);

    @RequestMapping("/AdminCategoryChange.elect")
    @ResponseBody
    public void categoryChange(int cid,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Category category = mainServer.findCategory();
        for (Category category1 :category.getCategories()){
            if(category1.getId() == cid){
                PrintWriter out = response.getWriter();
                out.write(JSONArray.fromObject(category1.getCategories()).toString());
                out.close();
                return;
            }
        }
    }

    @RequestMapping("/AdminLookBook.elect")
    public String AdminLookBook(int pid,HttpServletRequest request){
        Product product = adminServer.findProductByid(pid);
        request.setAttribute("product",product);
        Category category = mainServer.findCategory();
        List<Category> categoryList = category.getCategories();
        request.setAttribute("categoryList",categoryList);
        List<Integer> cateIds = adminServer.findCateIdByProductId(pid);
        Map<String,Integer> map = adminServer.judgeCate(cateIds,category);
        request.getSession().setAttribute("yijibiaoti",map.get("1"));
        request.getSession().setAttribute("erjibiaoti",map.get("2"));
        return "admin/book/desc.jsp";
    }

    @RequestMapping("/AdminAllBook.elect")
    public String AdminAllBook(HttpServletRequest request){
        List<Product> productList = adminServer.findAllProduct();
        request.setAttribute("productList",productList);
        return "admin/book/list.jsp";
    }

    @RequestMapping("/adminLogin.elect")
    public String adminLogin(Admin admin, HttpServletRequest request){
        admin = adminServer.login(admin);
        if(admin.equals(null)){
            request.setAttribute("admin_login_msg","账号或密码错误，请检查后重新输入！");
            return "login.jsp";
        }
        request.getSession().setAttribute("admin",admin);
        return "redirect:admin/main.jsp";
    }

    @RequestMapping("/AdminAllCategory.elect")
    public String AdminAllCategory(HttpServletRequest request){
        Category category = mainServer.findCategory();
        request.setAttribute("category",category);
        return "admin/category/list.jsp";
    }

    @RequestMapping("/findCategoryById.elect")
    @ResponseBody
    public void findCategoryById(int id, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        List<Category> categorys = adminServer.findCategorysById(id);
        JSONArray json = JSONArray.fromObject(categorys);
        try {
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/AdminCategoryList.elect")
    @ResponseBody
    public void AdminCategoryList(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Category category = mainServer.findCategory();
        List<Category> categoryList = category.getCategories();
        PrintWriter out = response.getWriter();
        out.write(JSONArray.fromObject(categoryList).toString());
        out.close();
    }


    @RequestMapping("/AdminEditCategory.elect")
    public String AdminEditCategory(int cid,HttpServletRequest request){
        Category category = adminServer.findCategoryById(cid);
        request.setAttribute("category",category);
        return "admin/category/mod.jsp";
    }


    @RequestMapping("/AdminUpdateCategory.elect")
    public String AdminUpdateCategory(Category category){
        adminServer.updateCategory(category);
        return "redirect:/admin/AdminAllCategory.elect";
    }

    @RequestMapping("/AdminDeleteCategory.elect")
    public String AdminDeleteCategory(int cid){
        adminServer.deleteCategory(cid);
        return "/admin/AdminAllCategory.elect";
    }

    @RequestMapping("/AdminAddCategory.elect")
    public String AdminAddCategory(Category category){
        logger.info(category);
        if(category.getId() == 0){
            category.setParent_id(1);
        }
        adminServer.addCategory(category);
        return "/admin/AdminAllCategory.elect";
    }
}
