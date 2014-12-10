package com.semanticbits.shoaib.configurationapproach.multiplecontextfiles;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by shoaib on 2/3/14.
 */

public class A implements InitializingBean{

    @PostConstruct
    public void init(){
        System.out.println("Init method A class");
    }

    public static void main(String[] args){
        String filename="file:/home/shoaib/Documents/myprograms/someprograms/src/main/java/com/semanticbits/shoaib/configurationapproach/multiplecontextfiles/multiplecontextfiles-a.xml";
        ApplicationContext context=ApplicationContextFactory.getApplicationContext(filename);
        context.getBean("a");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialising bean callback method");
    }
}
