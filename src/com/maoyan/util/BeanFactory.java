package com.maoyan.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class BeanFactory {
    //我们在利用java的三层架构开发时，如果用Web层直接创建service层，然后再用service层直接创建dao层 ，
    // 这样的话如果我们底层的实现类发生了变化，我们就要去修改源代码了，这很显然不是很符合开发的要求。我们可以通过利用“工厂模式+反射+配置文件”的模式来降低耦合度，
    // 从而只是通过修改配置文件就能实现我们的需求。
    public static Object createObject(String name){
      try {
        //创建一个读取XML文件的对象 用来指向XML文件的输入流
        SAXReader reader = new SAXReader();
        //得到xml文件application.xml的输入流
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("application.xml");
        Document document = reader.read(in);//传入xml文件的输入流,获取XML document对象
        Element rootElement= document.getRootElement();//通过document对象获取根节点 xml中的beans
        //通过根节点获取到根节点下所有子节点返回一个包含所有子节点的集合   xml中的所有bean
        List<Element> elementList = rootElement.elements();
        for (Element element:elementList){//遍历所有子节点,xml中的每个bean
          String id = element.attributeValue("id");//得到属性为id的值
          if(id.equals(name)){//如果id的值和传入的字符串相同
            String className= element.attributeValue("class");//得到属性为class的值，class的值为dao实现类的包名加类名
            Class c = Class.forName(className);//通过反射得到dao实现类的字节码对象
            //通过字节码对象创建该类的实例并把该实例返回
            return c.newInstance();
          }
        }
      } catch (DocumentException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
        System.out.println("调用DAO层方法失败！");
      }
      return null;
    }

    //解析XML，通过工具dom4j
}
