package com.semanticbits.shoaib.event;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * Created by shoaib on 2/7/14.
 */
public class EmailNotifier implements ApplicationListener<Event>{


    private String username;
    private String password;
    private String fromMailAddress;
    private Map<String,Object> emailHandlerMap;


    @Override
    public void onApplicationEvent(Event event) {

        System.out.println("Event is listened properly");
        EmailHandler handler=(EmailHandler)emailHandlerMap.get(event.getEmailAlertType().toString());
        for(String toMailAddress:event.getEmailAddressList()){
               handler.handleEmail(username,password,toMailAddress,fromMailAddress);
        }
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFromMailAddress(String fromMailAddress) {
        this.fromMailAddress = fromMailAddress;
    }

    public void setEmailHandlerMap(Map<String, Object> emailHandlerMap) {
        this.emailHandlerMap = emailHandlerMap;
    }
}
