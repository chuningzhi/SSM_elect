package com.elect.action.user;

import com.elect.entity.User;
import com.elect.server.UserServer;
import com.elect.utils.CodeUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Resource(name = "userServer")
    private UserServer userServer;
    @Resource(name = "codeUtil")
    private CodeUtil codeUtil;

    private Logger logger = Logger.getLogger(UserAction.class);

    @RequestMapping("/login.elect")
    public String login(User user,HttpServletRequest request){
        User u = userServer.login(user);
        if (u==null){
            request.setAttribute("login_msg","你输入的邮箱或密码有误，请重新输入！");
            return "login_form.jsp";
        }
        request.getSession().setAttribute("user",u);
        if (u.getIs_email_verify().equals("N")){
            logger.info(u.getEmail_verify_code());
            return "redirect:verify_form.jsp";
        }
        return "redirect:/main/goMain.elect";
    }


    @RequestMapping("/emailVCodeCheck.elect")
    @ResponseBody
    public void emailVCodeCheck(HttpServletResponse response,HttpServletRequest request,String emailVCode){
        User user = (User) request.getSession().getAttribute("user");
        PrintWriter out = null;
        logger.info(emailVCode);
        logger.info(user);
        try {
            out = response.getWriter();
        } catch (Exception e) {
            out.write("false");
            e.printStackTrace();
        }
        if(emailVCode.equals(user.getEmail_verify_code())){
            out.write("true");
            return;
        }
        out.write("false");
        out.close();
    }


    @RequestMapping("/logout.elect")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "/main/goMain.elect";
    }

    @RequestMapping("/verify.elect")
    public String verify(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        userServer.updateIsEmailVerify(user.getId());
        return "redirect:register_ok.jsp";
    }

    @RequestMapping("/regist.elect")
    public String regist(User user,HttpServletRequest request){
        String addr = request.getRemoteAddr();
        user.setLast_login_ip(addr);
        user= userServer.regist(user);
        request.getSession().setAttribute("user",user);
        return "redirect:verify_form.jsp";
    }

    @RequestMapping("/emailCheck.elect")
    @ResponseBody
    public void emailCheck(String email, HttpServletResponse response) throws IOException {
        User user = userServer.findUserByEmail(email);
        PrintWriter out = response.getWriter();
        if(user == null){
            out.write("false");
        }else {
            out.write("true");
        }
    }

    @RequestMapping("CodeCheck.elect")
    @ResponseBody
    public void codeCheck(String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num = (String) request.getSession().getAttribute("code");
        PrintWriter out = response.getWriter();
        if(num.equalsIgnoreCase(code)){
            out.write("true");
        }else {
            out.write("flase");
        }
    }

    @RequestMapping("code")
    @ResponseBody
    public void code(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(65, 30, BufferedImage.TYPE_INT_RGB);
        //拿到图片的画笔对象
        Graphics g = image.getGraphics();
        //给画笔设置颜色，将图片画出来
        Random ran = new Random();
        g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
        g.drawRect(0, 0, 80, 30);
        //拿出所有数字
        StringBuffer strb = new StringBuffer("");
        //将字母添加到数字的字符串中
        for(char c='A';c<='Z';c++) {
            strb.append(c);
        }
        //从strb字符串中随机取出五个字符，放入到code字符串中
        String code = "";
        for(int i=0;i<4;i++){
            code += strb.charAt(ran.nextInt(strb.length()));
        }
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
        g.setFont(new Font("宋体", Font.BOLD, 18));
        g.drawString(code, 10, 20);
        ImageIO.write(image, "jpeg", response.getOutputStream());
    }





}
