package training.another.packages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAnotherConfiguration {

    @Bean
    public MyAnotherBean myAnotherBean(){
        return new MyAnotherBean();
    }

}
