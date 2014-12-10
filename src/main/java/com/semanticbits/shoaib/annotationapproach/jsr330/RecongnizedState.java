package com.semanticbits.shoaib.annotationapproach.jsr330;

import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by shoaib on 2/6/14.
 */

@Named("recongnizedState")
@Singleton
public class RecongnizedState implements State {

    @Value("Maharashtra")
    private String name;

    @Override
    public String getDisplayName() {
        return name;
    }
}
