package com.semanticbits.shoaib.configurationapproach.autowiring.constructor;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/4/14.
 */
public class Student {

    private Address address;
    private Address homeAddress;

    public Student(Address address) {
        System.out.println("In Student's constructor");
        this.address = address;
        System.out.println(address.getPlace());

    }

//    public Student() {
//    }

    public void init(){
        System.out.println("In Student's init method");
    }

    public static void main(String[] args){
        ApplicationContext context=ApplicationContextFactory.getApplicationContext("autowire-contructor.xml");
        System.out.println(context.getBean("student",Student.class).address.getPlace());
//        System.out.println(context.getBean("student",Student.class).homeAddress.getPlace());
    }


}
