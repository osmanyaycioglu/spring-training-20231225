package training.spring.springtraining.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import training.spring.springtraining.beans.DynamicHello;
import training.spring.springtraining.beans.IHello;

@Profile("live")
@Configuration
public class MyLiveHelloConfiguration {

    @Bean("hello-def")
    public IHello helloDefault(@Value("${app.hello.prefix}") final String helloPrefixParam,
                               @Value("${app.goodbye.prefix}") final String goodbyePrefixParam) {
        return new DynamicHello(helloPrefixParam,
                                goodbyePrefixParam);
    }
}
