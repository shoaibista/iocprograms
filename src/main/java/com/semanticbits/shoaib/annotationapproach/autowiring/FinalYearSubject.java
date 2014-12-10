package com.semanticbits.shoaib.annotationapproach.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shoaib on 2/5/14.
 */
@Component("finalYearSubject")
public class FinalYearSubject implements Subject{

    @Value("Spring")
    private String  finalYearSubject;

    @Override
    public String getSubjectName() {
        return finalYearSubject;
    }
}
