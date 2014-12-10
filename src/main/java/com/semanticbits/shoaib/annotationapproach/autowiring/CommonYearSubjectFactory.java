package com.semanticbits.shoaib.annotationapproach.autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Named;

/**
 * Created by shoaib on 2/5/14.
 */
@Component
public class CommonYearSubjectFactory {


    /*
    * This will add bean with id as "commonYearSubject" to ApplicationContext and will be available for autowiring
    * with scope as singleton
    * */
    @Bean
    @Qualifier("commonYearSubject")
//    @Named("commonYearSubject")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public Subject getCommonYearSubjectFactory(){
        return new CommonYearSubject("Mechanics");
    }
}
