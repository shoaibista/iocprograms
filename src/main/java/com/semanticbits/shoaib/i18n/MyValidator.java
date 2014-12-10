package com.semanticbits.shoaib.i18n;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

import java.util.Locale;

/**
 * Created by shoaib on 2/6/14.
 */
public class MyValidator {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     *->The ApplicationContext interface extends an interface called MessageSource, and
     * therefore provides internationalization (i18n) functionality.
     *
     * ->Spring also provides the interface HierarchicalMessageSource, which can resolve messages hierarchically. Together these
     * interfaces provide the foundation upon which Spring effects message resolution. The methods defined
     * on these interfaces include:
     *
     *  • String getMessage(String code, Object[] args, String default, Locale loc):
     *         The basic method used to retrieve a message from the MessageSource. When no message is found
     *         for the specified locale, the default message is used. Any arguments passed in become replacement
     *         values, using the MessageFormat functionality provided by the standard library.
     *
     *   • String getMessage(String code, Object[] args, Locale loc): Essentially the same
     *        as the previous method, but with one difference: no default message can be specified; if the message
     *        cannot be found, a NoSuchMessageException is thrown.
     *
     *   • String getMessage(MessageSourceResolvable resolvable, Locale locale):
     *        All properties used in the preceding methods are also wrapped in a class named
     *         MessageSourceResolvable, which you can use with this method.
     *
     * */

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("i18n-spring.xml");
        MyValidator validator=context.getBean(MyValidator.class);

        if(validator.getAge()<12){
            System.out.println(context.getMessage("invalid.age",null,"Default",Locale.ENGLISH));
        }else{
            System.out.println(context.getMessage("valid.voting.age",new Object[]{"Rahul Gandhi"},"You can vote",Locale.UK));

        }
    }
}
