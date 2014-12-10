package com.semanticbits.shoaib.configurationapproach.beanpostprocessorandbeanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by shoaib on 2/5/14.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     *This method is called before instantiation of a bean i.e after constructor call and setter injection
     * and before init life cycle method call i.e before initialization
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("In bean post processor before initialization");

        if(bean instanceof Engineer){
         System.out.println("Engineer Name :-"+((Engineer) bean).getName());
         System.out.println("Bean Name :-" + beanName);
        }
        return bean;
    }


    /**
     *This method is called before instantiation of a bean i.e after constructor call and setter injection
     * and after init life cycle method call i.e before initialization
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof Engineer){
            ((Engineer) bean).setName("Emraan Hashmi");

        }
        System.out.println("In bean post processor after initialization");

        return bean;
    }
}
