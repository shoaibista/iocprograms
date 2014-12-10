package com.semanticbits.shoaib.configurationapproach.beanpostprocessorandbeanfactorypostprocessor;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by shoaib on 2/5/14.
 */
public class Subject implements DisposableBean{


    public void init(){
        System.out.println("Init method of Subject");
    }

    public void destroy(){
        System.out.println("Destroy method of Subject");
    }
}
