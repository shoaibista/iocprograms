package com.semanticbits.shoaib.event;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by shoaib on 2/7/14.
 */
public class StudentEmailHandler extends EmailHandler {


    @Override
    public void handleEmail(String username, String password, String toAddress, String fromAddress) {

        MessageSource messageSource=getMessageSource();
        String subject=messageSource.getMessage("email.student.subject",null, Locale.ENGLISH);

        sendRespectiveEmail(username,password,toAddress,fromAddress,subject,
                new StringBuffer(messageSource.getMessage("email.name",new Object[]{"Student"}, Locale.ENGLISH)));


    }
}
