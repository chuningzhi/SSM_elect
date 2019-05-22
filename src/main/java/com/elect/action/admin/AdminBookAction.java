package com.elect.action.admin;

import com.elect.entity.Book;
import com.elect.entity.Product;
import com.elect.server.AdminBookServer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller()
@RequestMapping("/adminBook")
public class AdminBookAction {
    @Resource(name = "adminBookServer")
    private AdminBookServer adminBookServer;


    private Logger logger = Logger.getLogger(AdminBookAction.class);

    @RequestMapping("/AdminModifyBook.elect")
    public String AdminModifyBook(String method, Product product,
                                  Book book, int cid, int childcid, HttpServletRequest request){
        if(method.equals("updateBook")) {
            product.setBook(book);
            List<Integer> cids = new ArrayList<>();
            HttpSession session = request.getSession();
            cids.add(cid);
            cids.add((Integer) session.getAttribute("yijibiaoti"));
            cids.add(childcid);
            cids.add((Integer) session.getAttribute("erjibiaoti"));
            adminBookServer.updateProduct(product,cids);
        }else if(method.equals("deleteBook")){
            adminBookServer.deleteBook(product.getId());
        }
        return "redirect:/admin/AdminAllBook.elect";
    }


    @RequestMapping("/AdminAddBook.elect")
    public String AdminAddBook(HttpServletRequest request){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        String picName = UUID.randomUUID().toString();
        Map<String,String> parameters = new HashMap<>();
        try {
            List<FileItem> items = sfu.parseRequest(request);
            for (FileItem item : items) {
                if(!item.isFormField()) {
                    String path = request.getServletContext().getRealPath("productImages");
                    String pathName = path+ File.separator+picName;
                    File file = new File(pathName);
                    item.write(file);
                }else {
                    parameters.put(item.getFieldName(),item.getString("utf-8"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Product product = new Product();
        product.setProduct_name(parameters.get("product_name"));
        product.setDescription(parameters.get("description"));
        product.setProduct_pic(picName);
        product.setFixed_price(Double.parseDouble(parameters.get("fixed_price")));
        product.setDang_price(Double.parseDouble(parameters.get("dang_price")));
        Book book = new Book();
        book.setAuthor(parameters.get("author"));
        book.setPublishing(parameters.get("publishing"));
        int cid = Integer.parseInt(parameters.get("cid"));
        int childCid = Integer.parseInt(parameters.get("childCid"));
        int pid = adminBookServer.addProduct(product);
        book.setId(pid);
        adminBookServer.insertBook(book);
        adminBookServer.addCategoryProduct(pid,cid);
        adminBookServer.addCategoryProduct(pid,childCid);
        return "redirect:/admin/AdminAllBook.elect";
    }

}
