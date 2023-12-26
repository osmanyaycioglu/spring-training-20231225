package training.spring.springtraining.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import training.spring.springtraining.beans.DynamicHello;
import training.spring.springtraining.beans.HelloTr;
import training.spring.springtraining.beans.IHello;

@Profile("dev")
@Configuration
public class MyDevHelloConfiguration {

    @Bean("hello-def")
    public IHello helloDefault() {
        return new HelloTr();
    }

}
