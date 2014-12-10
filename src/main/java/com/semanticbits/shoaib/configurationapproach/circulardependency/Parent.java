package com.semanticbits.shoaib.configurationapproach.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shoaib on 2/3/14.
 */
@Component
public class Parent {

    private GrandParent grandParent;

    @Autowired
    public Parent(GrandParent grandParent) {
        this.grandParent = grandParent;
    }
}
