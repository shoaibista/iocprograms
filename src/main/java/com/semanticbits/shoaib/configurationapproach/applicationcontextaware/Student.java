package com.semanticbits.shoaib.configurationapproach.applicationcontextaware;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by shoaib on 2/4/14.
 */
public class Student implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    private Address address;


    /** When a non singleton bean is injected inside a singleton bean then as we create object
     * of singleton bean here Student then Address which is prototype is injected at once hence looses its
     * prototypeness. So in order to get that we can get prototype bean by directly calling getBean()
     * This can be done in this way. By extending class to ApplicationContextAware this we can become aware about
     * the ApplicationContext and can use ApplicationContext any where we want.
     * But this approach is not recommended as it because the business code is aware of and coupled to the Spring
        Framework.
     * Hence the solution for these is method injection
     */
    public Address getAddress() {
        return applicationContext.getBean("address",Address.class);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }


    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("applicationcontextaware-spring.xml");
        Student student=context.getBean("student",Student.class);
        System.out.println(student.getAddress()); //all four different references
        System.out.println(student.getAddress());
        System.out.println(student.getAddress());
        System.out.println(student.getAddress());
    }

}
