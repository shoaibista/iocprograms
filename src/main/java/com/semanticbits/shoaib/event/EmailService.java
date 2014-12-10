package com.semanticbits.shoaib.event;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shoaib on 2/7/14.
 */
public class EmailService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    private Map<String,Object> emailListMap;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
            this.applicationEventPublisher=applicationEventPublisher;
    }

    public void sendEmail(EmailAlertType alertType){

            Event event = new Event(new Date());
            event.setEmailAlertType(alertType);
            event.setEmailAddressList((List<String>) emailListMap.get(alertType.toString()));
            applicationEventPublisher.publishEvent(event);


    }

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("event-spring.xml");
        EmailService emailService=context.getBean(EmailService.class);
        emailService.sendEmail(EmailAlertType.STUDENT_EVENT_ALERT);
    }

    public void setEmailListMap(Map<String, Object> emailListMap) {
        this.emailListMap = emailListMap;
    }
}
