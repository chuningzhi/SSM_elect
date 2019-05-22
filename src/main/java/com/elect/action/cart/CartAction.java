package com.elect.action.cart;

import com.elect.entity.Cart;
import com.elect.entity.User;
import com.elect.server.CartServer;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartAction {
    @Resource(name = "cartServer")
    private CartServer cartServer;

    private Logger logger = Logger.getLogger(CartAction.class);

    @RequestMapping("/goCartRestore")
    public String goCartRestore(int cart_id,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        cartServer.cartUpdateIsdele(cart_id,"N");
        return "redirect:goCart.elect?user_id="+user.getId();
    }

    @RequestMapping("/goCartDele")
    public String goCartDele(int cart_id,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        cartServer.cartUpdateIsdele(cart_id,"Y");
        return "redirect:goCart.elect?user_id="+user.getId();
    }

    @RequestMapping("/changeNum.elect")
    @ResponseBody
    public void changeNum(int cart_id,int inputNum,HttpServletResponse response,HttpServletRequest request) throws IOException {
        cartServer.changeCartNumById(cart_id,inputNum);
        PrintWriter out = response.getWriter();
        User user = (User) request.getSession().getAttribute("user");
        List<Cart> carts = cartServer.findCartByUserId(user.getId());
        String totalPrice = cartServer.countTotalPrice(carts);
        String economyPrice = cartServer.countEconomyPrice(carts);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalPrice",totalPrice);
        jsonObject.put("economyPrice",economyPrice);
        out.print(jsonObject.toString());
        out.close();
    }


    @RequestMapping("/addProduct.elect")
    @ResponseBody
    public void addProduct(int product_id,int user_id, HttpServletResponse response) throws IOException {
        List<Cart> carts = cartServer.findCartByUserId(user_id);
        PrintWriter out = response.getWriter();
        Boolean flag = cartServer.addCart(product_id, user_id);
        if(flag == true){
            out.print(JSONObject.fromObject(true).toString());
        }else {
            out.print(JSONObject.fromObject(false).toString());
        }
        out.close();
    }


    @RequestMapping("/goCart.elect")
    public String goCart(String user_id, HttpServletRequest request){
        logger.info(user_id);
        if(user_id.equals(null) || user_id.equals("")){
            return "redirect:/user/login_form.jsp";
        }
        int user_id_int = Integer.parseInt(user_id);
        List<Cart> carts = cartServer.findCartByUserId(user_id_int);
        request.setAttribute("carts", carts);
        String totalPrice = cartServer.countTotalPrice(carts);
        request.setAttribute("totalPrice",totalPrice);
        String economyPrice = cartServer.countEconomyPrice(carts);
        request.setAttribute("economyPrice",economyPrice);
        return "cart_list.jsp";
    }
}
