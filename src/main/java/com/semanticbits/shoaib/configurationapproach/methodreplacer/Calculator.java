package com.semanticbits.shoaib.configurationapproach.methodreplacer;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/4/14.
 */
public class Calculator {

    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int add(int a, int b){
        return a+b;
    }

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("methodreplacer-spring.xml");
        Calculator calculator=context.getBean("calculator",Calculator.class);

        //Instead of calling the add method of above class it will call reimplement method just to change business logic
        System.out.println("Addition of two no: " + calculator.add(calculator.a, calculator.b));
    }

}
