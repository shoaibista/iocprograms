package com.semanticbits.shoaib.configurationapproach.beannameaware;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/4/14.
 */
public class Project implements BeanNameAware,InitializingBean {

    private static String beanName;

    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     *BeanNameAware makes the object aware of their bean name in a ApplicationContext
     * Called before lifecycle init method or afterPropertiesSet of InitialisingBean
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("To make the aware of bean name " +name);
        beanName=name;
    }

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("beannameaware-spring.xml");
        Project project=context.getBean(beanName,Project.class);
        System.out.println("Company Name :"+project.getCompany().getName());
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("In the InitialisingBean's afterPropertiesSet method");
    }
}
