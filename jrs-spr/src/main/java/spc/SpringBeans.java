package spc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeans {

    @Bean
    public AcmeService acmeService() {
        return new AcmeService();
    }

}
