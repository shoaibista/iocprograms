package com.semanticbits.shoaib.annotationapproach.jsr330;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

/**
 * Created by shoaib on 2/6/14.
 */
@Configuration
@ComponentScan(basePackages = "com.semanticbits.shoaib.annotationapproach.jsr330")
public class BeanConfigurationClass {

   @Bean
   @Scope(value= BeanDefinition.SCOPE_SINGLETON/*,proxyMode = ScopedProxyMode.TARGET_CLASS*/)
   @Qualifier("country")
   public Country getCountry(){
       return new Country();
   }

}
