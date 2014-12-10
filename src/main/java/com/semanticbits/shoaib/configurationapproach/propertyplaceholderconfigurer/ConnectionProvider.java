package com.semanticbits.shoaib.configurationapproach.propertyplaceholderconfigurer;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/5/14.
 */
public class ConnectionProvider {

    private String driverClass;
    private String url;
    private String password;
    private String username;
    private boolean showSQL;

    public boolean isShowSQL() {
        return showSQL;
    }

    public void setShowSQL(boolean showSQL) {
        this.showSQL = showSQL;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString(){

        return "DriverClass name    :-"+driverClass+
                "\n Url                :-"+url+
                "\nUsername            :-"+username+
                "\nPassword            :-"+password+
                "\nShow Sql statements :"+showSQL;
    }

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("propertyplaceholderconfigurer.xml");
        System.out.println(context.getBean("connectionProvider"));
    }
}
