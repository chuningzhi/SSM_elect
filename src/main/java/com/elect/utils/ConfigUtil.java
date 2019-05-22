package com.elect.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component("configUtil")
public class ConfigUtil {

    public static final String DBCP_PRO = "dbcp.properties";
    public static final String FACTORY_PRO = "dao.properties";
    public static final String PAGE_PRO = "page.properties";
    public String getValue(String type,String key){
        Properties pro = new Properties();
        try {
            pro.load(ConfigUtil.class.getClassLoader().getResourceAsStream(type));
        }catch (IOException e){
            e.printStackTrace();
        }
        return pro.getProperty(key);
    }
}
