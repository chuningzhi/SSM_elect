package com.elect.action.order;

import com.elect.entity.Address;
import com.elect.entity.Cart;
import com.elect.entity.Item;
import com.elect.entity.Order;
import com.elect.server.CartServer;
import com.elect.server.OrderServer;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderAction {
    @Resource(name = "cartServer")
    private CartServer cartServer;
    @Resource(name = "orderServer")
    private OrderServer orderServer;


    @RequestMapping("/addOrder.elect")
    public String addOrder(Order order, int flag,HttpServletRequest request){
        System.out.println(order);
        List<Item> items = (List<Item>) request.getSession().getAttribute("items");
        order = orderServer.addOrder(order,items,flag);
        cartServer.deleCart(order.getUser_id());
        request.setAttribute("order",order);
        return "order_ok.jsp";
    }

    @RequestMapping("/gainAddress.elect")
    public void gainAddress(int index, HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Address> addressList = (List<Address>) request.getSession().getAttribute("addressList");
        Address address = addressList.get(index);
        JSONObject jsonObject = JSONObject.fromObject(address);
        out.print(jsonObject.toString());
        out.close();
    }

    @RequestMapping("/goAddress.elect")
    public String goAddress(int user_id,HttpServletRequest request){
        List<Address> addressList = orderServer.findAddress(user_id);
        request.getSession().setAttribute("addressList",addressList);
        return "address_form.jsp";
    }

    @RequestMapping("/goOrder.elect")
    public String goOrder(int user_id, HttpServletRequest request){
        List<Cart> carts = cartServer.findCartByUserId(user_id);
        List<Item> items = orderServer.findItems(carts,user_id);
        request.getSession().setAttribute("items",items);
        return "order_info.jsp";
    }
}
