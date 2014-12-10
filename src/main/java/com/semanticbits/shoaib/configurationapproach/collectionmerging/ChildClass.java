package com.semanticbits.shoaib.configurationapproach.collectionmerging;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by shoaib on 2/3/14.
 */
public class ChildClass {

    private List<String> subjects;
    private Map information;

    public Map getInformation() {
        return information;
    }

    public void setInformation(Map information) {
        this.information = information;
    }


    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public static void main(String[] args){
        ApplicationContext context=ApplicationContextFactory.getApplicationContext("collectionmerging-spring.xml");
        ChildClass childClass=context.getBean("child",ChildClass.class);
        System.out.println(childClass.getSubjects());
        System.out.println(childClass.getInformation());

    }
}
