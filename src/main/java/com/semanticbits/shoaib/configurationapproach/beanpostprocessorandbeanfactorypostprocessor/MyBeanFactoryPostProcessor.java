package com.semanticbits.shoaib.configurationapproach.beanpostprocessorandbeanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by shoaib on 2/5/14.
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
    *This method is called before instantiation of all bean and after instantiation of BeanFactory
    */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("In bean Factory post processor");
    }
}
