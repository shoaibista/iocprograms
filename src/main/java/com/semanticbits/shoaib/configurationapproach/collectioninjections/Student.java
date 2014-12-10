package com.semanticbits.shoaib.configurationapproach.collectioninjections;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by shoaib on 2/3/14.
 */
public class Student {

    private List<String> subjects;
    private Set<String> hometowns;
    private Map infoMap;
    private String[] interests;
    private Properties myProperties;

    public Properties getMyProperties() {
        return myProperties;
    }

    public void setMyProperties(Properties myProperties) {
        this.myProperties = myProperties;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public Map getInfoMap() {
        return infoMap;
    }

    public void setInfoMap(Map infoMap) {
        this.infoMap = infoMap;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Set<String> getHometowns() {
        return hometowns;
    }

    public void setHometowns(Set<String> hometowns) {
        this.hometowns = hometowns;
    }

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("collectionInjection-spring.xml");
        Student student=context.getBean("student",Student.class);
        System.out.println(student.getHometowns());
        System.out.println(student.getSubjects());
        System.out.println(student.getInfoMap());
        System.out.println(student.getInfoMap().get("height").getClass());
        System.out.println(student.getInfoMap().get("weight").getClass());
        System.out.println(student.getInterests()[0]);
        System.out.println(student.getInterests()[1]);
        System.out.println(student.getMyProperties());

    }
}
