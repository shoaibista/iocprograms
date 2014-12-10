package com.semanticbits.shoaib.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shoaib on 2/3/14.
 */
public class ApplicationContextFactory {


    private ApplicationContextFactory(){}

    public static ApplicationContext getApplicationContext(String filename){
        return new ClassPathXmlApplicationContext(filename);
    }
}
