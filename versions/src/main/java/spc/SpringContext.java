package spc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

    private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    public static <T> T beanOf(Class<T> object) {
        return applicationContext.getBean(object);
    }

}
