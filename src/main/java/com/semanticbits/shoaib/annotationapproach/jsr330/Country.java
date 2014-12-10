package com.semanticbits.shoaib.annotationapproach.jsr330;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



/**
 * Created by shoaib on 2/6/14.
 */
public class Country {


    /**
     * As here case is different
     * We need to specify the paramName matching to @Named("unionTerritory") on particular class
     * If not then we need to specify @Named("unionTerritory")
     * */

//    @Inject @Named("unionTerritory")
//    private State unionTerritories;
//


    @Autowired
    private State unionTerritory;

    private State recongnizedState;


    /**
     * As we are using @Inject Attribute on Setter hence it will check parameter name and try to match with
     * the @Named("recongnizedState") on RecognizedState class.
     * As it matches hence no conflicts hence happily injected.
     * If param name is recState then before we need to specify @Named("recongnizedState") State recState
     * */
    @Autowired
    public void setRecongnizedState(State recongnizedState) {
        this.recongnizedState = recongnizedState;
    }

    public static void main(String[] args){
        ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfigurationClass.class);

        //Takes name of method as bean name
        Country country=context.getBean("getCountry",Country.class);

        //Another way
//        Country country1=context.getBean(Country.class);

        System.out.println(country);
        System.out.println(country.recongnizedState.getDisplayName());
        System.out.println(country.unionTerritory.getDisplayName());

    }
}
