package com.semanticbits.shoaib.annotationapproach.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shoaib on 2/5/14.
 */
@Component(value = "firstYearSubject")
public class FirstYearSubject implements Subject {

    @Value("HTML")
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }
}
