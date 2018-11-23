package myspring.com.prahlad1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // 1 BeanFactory
        // 2. ApplicationContext
       // BeanFacto
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Vehicle c = (Vehicle)context.getBean("car");
        c.drive();
        Tyre t = (Tyre) context.getBean("tyre");
        System.out.println(t);
    }
}
