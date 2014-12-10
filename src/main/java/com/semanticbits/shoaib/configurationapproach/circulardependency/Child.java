package com.semanticbits.shoaib.configurationapproach.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by shoaib on 2/3/14.
 */
@Component
public class Child {

    private Parent parent;

    @Autowired
    public Child(Parent parent) {
        this.parent = parent;
    }

    public static void main(String[] args){

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        Child child=context.getBean("child",Child.class);

    }
}
