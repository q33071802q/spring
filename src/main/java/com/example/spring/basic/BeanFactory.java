package com.example.spring.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    //定义properties对象
    private static Properties properties;
    //定义一个Map 用于存放要创建的对象 称为容器
    private static Map<String,Object> beans;

    /**
     * 初始化的时候直接创建好 然后放到容器里 直接可以去容器里取了
     */
    static {
        try {
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            //实例化容器
            beans = new HashMap<>();
            //取出配置文件中的所有key
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
       return beans.get(beanName);
    }
}
