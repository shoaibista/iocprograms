package com.semanticbits.shoaib.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by shoaib on 2/7/14.
 */
public class BlackListEvent extends ApplicationEvent {


    private String address;
    private String name;



    /**
     * Custom event creation in spring.
     *
     *1)In order to create custom event a class should extend ApplicationEvent class who don't have default constructor
     * So you need to create a constructor with Parent as Object source and internally calling super(source)
     *
     *2)Then we need to publish this event using ApplicationEventPublisher and call its publishEvent(ourEvent)
     *      Please check EmailService class for this
     *
     *3)Then we need to listen this event using ApplicationListener<T> which will has onApplicationEvent(T t)
     *      Please check EmailNotifier class for this
     * */

    public BlackListEvent(Object source){
        super(source);

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
