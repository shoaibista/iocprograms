package com.semanticbits.shoaib.configurationapproach.beanaliasing;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/3/14.
 */
public class Child {

    private Parent parent;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public static void main(String[] args){
        System.out.println("");
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("beanaliasing-spring.xml");
        Child child=context.getBean("child",Child.class);
        System.out.println("Child Ref :"+child);
        System.out.println("Parent Ref :"+child.getParent());
    }
}
