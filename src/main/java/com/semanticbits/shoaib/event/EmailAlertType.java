package com.semanticbits.shoaib.event;

/**
 * Created by shoaib on 2/7/14.
 */
public enum EmailAlertType {


    PARENT_EVENT_ALERT("Parent"),
    STUDENT_EVENT_ALERT("Student"),
    TEACHER_EVENT_ALERT("Teacher");


    private String emailType;

    EmailAlertType(String emailType) {
        this.emailType = emailType;
    }
}
