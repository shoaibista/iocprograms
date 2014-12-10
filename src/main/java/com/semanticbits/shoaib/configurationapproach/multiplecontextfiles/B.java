package com.semanticbits.shoaib.configurationapproach.multiplecontextfiles;

import javax.annotation.PostConstruct;

/**
 * Created by shoaib on 2/3/14.
 */
public class B {

    @PostConstruct
    public void init(){
        System.out.println("Init method B class");
    }

}
