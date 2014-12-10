package com.semanticbits.shoaib.annotationapproach.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shoaib on 2/5/14.
 */
@Component("thirdYearSubject")
public class ThirdYearSubject implements Subject {

    /*
    * This is equivalent to setter injection where <property name="thirdYearSubjectName" value="Hibernate"/>
    * value attribute for Value annotation or any annotation is optional if only one attribute is there.
    * @Value(value="Hibernate") or @Value("Hibernate") is same.
    * @Value(someAttr="",value="Hibernate") then value attribute is mandatory
    * */
    @Value("Hibernate")
    private String thirdYearSubjectName;

    @Override
    public String getSubjectName() {
        return thirdYearSubjectName;
    }
}
