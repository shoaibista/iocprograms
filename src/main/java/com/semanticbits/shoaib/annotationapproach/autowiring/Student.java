package com.semanticbits.shoaib.annotationapproach.autowiring;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by shoaib on 2/5/14.
 */
@Component(value = "student")
public class Student {

    private static final Logger logger = Logger.getLogger(Student.class);

    /**
     * This is one type of Collection injection now it will gather all the beans of type Subject and inject into that.
     * */
    @Autowired
    private List<Subject> allSubjects;

    public List<Subject> getAllSubjects() {
        return allSubjects;
    }

    /**
     * The annotation @Autowired work as autowire byType
     * Now there are two types of Subject here FirstYear and SecondYear hence it has confusion which type to inject in Subject class.
     * This confusion can be avoid by using @Qualifier attribute which takes name of bean which is specified at @Component tag
     * Here no setter is required.
     */
    @Autowired
    @Qualifier(value = "firstYearSubject")
    private Subject firstYearSubject;

    private Subject secondYearSubject;

    private Subject thirdYearSubject;

    /**
     * The @Resource annotation is JCR-250 annotation more flexible and makes avoid using @Qualifier attribute
     * and is used for autowiring of bean
     * */

    @Resource(name = "finalYearSubject")
    private Subject finalYearSubject;


    @Autowired @Qualifier("commonYearSubject")
    private Subject commonYearSubject;

    /*
    * Although it is setter injection we used @Qualifier because parameter name(thirdYrSubject) is different than
    * @Component("thirdYearSubject"). Here it is thirdYrSubject
    * So to specify it that which type to be injected we write @Qualifier("thirdYearSubject")
    * */
    @Autowired
    public void setThirdYearSubject(@Qualifier("thirdYearSubject") Subject thirdYrSubject) {
        this.thirdYearSubject = thirdYrSubject;
    }

    /*
        * Now as we are specifying annotation on setter it will match the parameter name with
        * @Component(value="secondYearName"). So here @Qualifier attribute is not required.
        * If parameter name is something like secYrName then it would not take this value and would give error as no bean found and
        * there are many beans of type Subject
        * */
    @Autowired
    public void setSecondYearSubject(Subject secondYearSubject) {
        this.secondYearSubject = secondYearSubject;
    }

    private Address myAddress;

    public Address getMyAddress() {
        return myAddress;
    }

    @Inject
    public void setMyAddress(Address myAddress) {
        this.myAddress = myAddress;
    }


    public void displaySubjectNames(){
        System.out.println("Common Year Subject :"+commonYearSubject.getSubjectName());
        System.out.println("First Year Subject :"+firstYearSubject.getSubjectName());
        System.out.println("Second Year Subject :"+secondYearSubject.getSubjectName());
        System.out.println("Third Year Subject :"+thirdYearSubject.getSubjectName());
        System.out.println("Final Year Subject :"+finalYearSubject.getSubjectName());
    }


    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("classpath*:annotationapproach/autowiring.xml");
        Student student=context.getBean("student",Student.class);
        System.out.println(student.getMyAddress());
        student.displaySubjectNames();
        System.out.println("\nOutput by Collection Injection");
        for(Subject subject:student.getAllSubjects()){
            System.out.println(subject.getClass().getSimpleName()+"..."+subject.getSubjectName());
        }

        if(logger.isDebugEnabled()){
            logger.debug(student);
        }
        if(logger.isInfoEnabled()){
            logger.info(student.allSubjects);
        }

    }
}
