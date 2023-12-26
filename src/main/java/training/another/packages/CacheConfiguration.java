package training.another.packages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    @Bean
    public MyCache myCache(){
        return new MyCache();
    }

}
