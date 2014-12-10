package com.semanticbits.shoaib.annotationapproach.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shoaib on 2/5/14.
 */
@Component(value = "secondYearSubject")
public class SecondYearSubject implements Subject {

    @Value(value = "Java")
    private String name;

    public String getSubjectName() {
        return name;
    }
}
