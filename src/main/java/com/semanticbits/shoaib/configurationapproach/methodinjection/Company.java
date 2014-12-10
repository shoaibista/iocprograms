package com.semanticbits.shoaib.configurationapproach.methodinjection;

import com.semanticbits.shoaib.util.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by shoaib on 2/4/14.
 */
public abstract class Company {

    private Agent agent;

    /**
     * <table border="2">
     * <th>Sr No.</th> <th>Dependent bean</th>  <th>Dependency bean</th>   <th>Scope of inject of Dependency</th>
     *
     * <tr><td>1</td>    <td>Singleton</td>      <td>Singleton</td>   <td>Singleton</td></tr>
     * <tr><td>2</td>    <td>Prototype</td>      <td>Prototype</td>  <td>Prototype</td></tr>
     * <tr><td>3</td>    <td>Prototype</td>      <td>Singleton</td>  <td>Singleton</td></tr>
     * <tr><td>4</td>    <td>Singleton</td>      <td>Prototype</td>  <td>Singleton</td></tr>
     *</table>
     * <br>
     *   See the case number 4. where if prototype bean is injected into singleton bean then scope of the bean becomes virtually
     *   to Singleton because as dependent bean is Singleton hence it is created once and its dependency is injected only once
     *   making the dependency bean as virtually singleton.<br>
     *   So inorder to get every time new reference of dependency we go for method injection by using method look up.
     *   <br>
     *   <b></u>Syntax:</u></b>
     *   <br>
     *   <h3>
     *   (public|protected) [abstract] (return-type) theMethodName(no-arguments);
     *   </h3>
     *   We instruct the spring container that look this method and return each time new reference of this object.
     *   See methodinjection-spring.xml for configuration
     */
    public abstract Agent getAgent();

    public static void main(String[] args){
        ApplicationContext context= ApplicationContextFactory.getApplicationContext("methodinjection-spring.xml");
        Company company=context.getBean("company",Company.class);
        System.out.println(company.getAgent());
        System.out.println(company.getAgent());
        System.out.println(company.getAgent());
        System.out.println(company.getAgent());
    }
}
