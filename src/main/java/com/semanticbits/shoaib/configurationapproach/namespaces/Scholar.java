package com.semanticbits.shoaib.configurationapproach.namespaces;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/4/14.
 */
public class Scholar {

    private University university1;
    private University university2;

    public Scholar(){}

    public Scholar(University university2) {
        this.university2 = university2;
    }

    public University getUniversity1() {

        return university1;
    }

    public void setUniversity1(University university1) {
        this.university1 = university1;
    }

    public static void main(String[] args){
        ApplicationContext context=ApplicationContextFactory.getApplicationContext("namespace-spring.xml");
        Scholar scholar=context.getBean("scholar",Scholar.class);
        System.out.println(scholar.getUniversity1());
        System.out.println(scholar.university2.getUniversityName());

    }
}
