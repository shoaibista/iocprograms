package com.semanticbits.shoaib.configurationapproach.beanpostprocessorandbeanfactorypostprocessor;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by shoaib on 2/5/14.
 */
public class Engineer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("In the Setter method");
        this.name = name;
    }

    public void init(){
        System.out.println("Init method of Engineer");
    }

    public void destroy(){
        System.out.println("Destroy method of Engineer");
    }

    public static void main(String[] args){
       AbstractApplicationContext context= (AbstractApplicationContext)ApplicationContextFactory.getApplicationContext("beanpostprocessorandbeanfactorypostprocessor.xml");
        Engineer engineer=context.getBean("engineer",Engineer.class);
        System.out.println("Name :"+engineer.getName());
        context.registerShutdownHook();
    }
}
