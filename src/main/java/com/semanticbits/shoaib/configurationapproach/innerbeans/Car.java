package com.semanticbits.shoaib.configurationapproach.innerbeans;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by shoaib on 2/3/14.
 */
public class Car {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void init(){
        System.out.println("Car init method");
    }
    public void destroy(){
        System.out.println("Car destroy method");
    }

    public static void main(String[] args){
        ConfigurableApplicationContext context=(ConfigurableApplicationContext)ApplicationContextFactory.getApplicationContext("innerbeans-spring.xml");
        Car car=context.getBean("car",Car.class);
        context.getBeanFactory().destroyBean("car",car);
        context.getBeanFactory().destroySingletons();
        context.getBeanFactory().destroySingletons();

//
   }
}
