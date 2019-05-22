package com.elect.utils;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.UUID;

@Component("codeUtil")
public class CodeUtil {
    public BufferedImage code(){
        BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        //拿到图片的画笔对象
        Graphics g = image.getGraphics();
        //给画笔设置颜色，将图片画出来
        Random ran = new Random();
        g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
        g.drawRect(0, 0, 80, 30);
        //拿出所有数字
        StringBuffer strb = new StringBuffer();
        //将字母添加到数字的字符串中
        for(char c='A';c<='Z';c++) {
            strb.append(c);
        }
        //从strb字符串中随机取出五个字符，放入到code字符串中
        String code = "";
        for(int i=0;i<4;i++){
            code += strb.charAt(ran.nextInt(strb.length()));
        }
        g.setColor(new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
        g.setFont(new Font("宋体", Font.BOLD, 18));
        g.drawString(code, 10, 20);
        return image;
    }

    public String emailVCode(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
