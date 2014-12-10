package com.semanticbits.shoaib.event;

import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * Created by shoaib on 2/7/14.
 */
public class Event extends ApplicationEvent {


    private List<String> emailAddressList;
    private EmailAlertType emailAlertType;

    public void setEmailAlertType(EmailAlertType emailAlertType) {
        this.emailAlertType = emailAlertType;
    }

    public List<String> getEmailAddressList() {
        return emailAddressList;
    }

    public void setEmailAddressList(List<String> emailAddressList) {
        this.emailAddressList = emailAddressList;
    }

    public EmailAlertType getEmailAlertType() {
        return emailAlertType;
    }

    public Event(Object source) {
        super(source);
    }
}
