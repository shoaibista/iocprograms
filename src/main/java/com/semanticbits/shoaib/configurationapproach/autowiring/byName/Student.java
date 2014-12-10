package com.semanticbits.shoaib.configurationapproach.autowiring.byName;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/4/14.
 */
public class Student {

    private Address address;
    private Address homeAddress;


    public void setAddress(Address myAddress) {
        this.address = myAddress;
        System.out.println("In the setter setAddress");
    }


    public void setHomeAddress(Address myHomeAddress) {
        this.homeAddress = myHomeAddress;
        System.out.println("In the setter setHomeAddress");
    }

    public void init(){
        System.out.println("In Student's init method");
    }

    public static void main(String[] args){
        ApplicationContext context=ApplicationContextFactory.getApplicationContext("autowire-byName.xml");
        System.out.println(context.getBean("student",Student.class).address);
        System.out.println(context.getBean("student",Student.class).homeAddress);
    }


}
