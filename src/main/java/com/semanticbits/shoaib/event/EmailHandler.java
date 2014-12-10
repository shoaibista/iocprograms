package com.semanticbits.shoaib.event;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by shoaib on 2/7/14.
 */
public abstract class EmailHandler implements MessageSourceAware {

    public abstract void handleEmail(String username,String password,String toAddress,String fromAddress);


    private MessageSource messageSource;



    public void sendRespectiveEmail(String username,String password,String toMailAddress,String fromMailAddress,String subject,StringBuffer emailMessage){
        final String user = username;
        final String pwd = password;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pwd);
                    }
                });

        //preparing message
        emailMessage.append(messageSource.getMessage("email.body",null,null,Locale.ENGLISH));
        emailMessage.append(messageSource.getMessage("email.end",null,null,Locale.ENGLISH));
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMailAddress));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toMailAddress));
            message.setSubject(subject);
            message.setContent(emailMessage.toString(),"text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
