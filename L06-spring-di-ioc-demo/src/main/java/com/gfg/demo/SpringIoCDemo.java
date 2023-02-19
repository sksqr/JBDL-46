package com.gfg.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringIoCDemo {

    public static void main(String[] args) {
//         Spring IoC
        Resource resource = new ClassPathResource("projectbeans.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        Engine engine1 = (Engine) factory.getBean("engine1");
//        System.out.println(engine1);
//        Engine engine2 = (Engine) factory.getBean("engine1");
//        System.out.println(engine2);
//
//        if(engine1 == engine2){
//            System.out.println("both objects(beans) are same");
//        }
//        else {
//            System.out.println("both objects(beans) are not same");
//        }
//
//        Car car1 = (Car) factory.getBean("car1");
//        System.out.println(car1);
//        Engine engine3 = (Engine) factory.getBean("engine3");
//        if(engine3 == car1.getEngine()){
//            System.out.println("both objects(beans) are same");
//        }
//        else {
//            System.out.println("both objects(beans) are not same");
//        }
//
//
//
//




        // its an implementation of BeanFactor
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("projectbeans.xml");
        Engine engine2 = (Engine) context.getBean("engine2");
        System.out.println(engine2);
        //Spring dependency injection
        Car hexa = (Car) context.getBean("car1");
        hexa.runCar();
        context.close();

    }

}
