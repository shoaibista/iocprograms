package com.semanticbits.shoaib.configurationapproach.dependsonandlazyinit;

import javax.annotation.PostConstruct;

/**
 * Created by shoaib on 2/4/14.
 */
public class HrResource {


    @PostConstruct
    public void init(){
        System.out.println("HrResource's Init Method");
    }
}
