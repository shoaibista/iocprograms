package com.semanticbits.shoaib.configurationapproach.methodreplacer;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by shoaib on 2/4/14.
 */
public class MyMethodReplacer implements MethodReplacer {


    /**
     *Suppose if you are not happy with the implementation of the current business logic and instead of that you want to
     * call another method which will improve the logic hence we can achieve that by using MethodReplacer concept
     *
     * ->Here Class should implement org.springframework.beans.factory.support.MethodReplacer interface thus
     *  by overriding its reimplement method
     *  @param obj,
     *  @param method,
     *  @param args
     *
     *  We are saying to spring container that whenever business logic method is called, dont call that business logic method
     *  instead call this reimplement method
     *  We need to configure this scenario in configuration files. Please check methodreplacer-spring.xml
     */

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("Object :"+obj);
        System.out.println("Method Name :"+method.getName());
        System.out.println("First arg :"+args[0]);
        System.out.println("Second arg :"+args[1]);
        return ((Integer)args[0]+(Integer)args[1])*10;
    }
}
