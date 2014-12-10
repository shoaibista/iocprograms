package com.semanticbits.shoaib.configurationapproach.dependsonandlazyinit;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by shoaib on 2/4/14.
 */
public class Timesheet implements BeanNameAware{


    @PostConstruct
    public void init(){
        System.out.println("Timesheet's Init Method");
    }

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("dependsonlazyinit-spring.xml");
        System.out.println("\nNow Lazy Init and Depends on Output: \n");
        context.getBean("timesheet2");
    }


    /**
     *BeanNameAware makes the object aware of their bean name in a ApplicationContext
     * Called before lifecycle init method or afterPropertiesSet of InitialisingBean
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("To make the aware of name of bean :"+name);
    }
}
