package com.semanticbits.shoaib.annotationapproach.autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by shoaib on 2/5/14.
 */
public class CommonYearSubject implements Subject {

    public CommonYearSubject() {
    }

//    @Value("Mechanics")
    private String commonYearSubject;


    public CommonYearSubject(String commonYearSubject) {
        this.commonYearSubject = commonYearSubject;
    }

    @Override
    public String getSubjectName() {
        return commonYearSubject;
    }
}
