package training.spring.springtraining.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:my.properties")
public class HelloConfiguration {

    @Bean
    public IHello helloEnglish() {
        return new DynamicHello("Hello",
                                "Goodbye");
    }

    @Bean("hello-tr")
    public IHello helloTurkish() {
        return new DynamicHello("TR Selam ",
                                "TR Güle güle");
    }

    @Bean("hello-default")
    @Primary
    public IHello helloDefault(@Value("${app.hello.prefix}") final String helloPrefixParam,
                               @Value("${app.goodbye.prefix}") final String goodbyePrefixParam) {
        return new DynamicHello(helloPrefixParam,
                                goodbyePrefixParam);
    }

    @Qualifier("tr-dili")
    @Bean("hello-another-default")
    public IHello helloDefault(final Environment environmentParam) {
        return new DynamicHello(environmentParam.getProperty("deneme.text"),
                                environmentParam.getProperty("app.goodbye.prefix"));
    }

    @Bean("hello-yet-another-default")
    public IHello helloDefault(final ApplicationContext contextParam) {
        final Environment environmentLoc = contextParam.getEnvironment();
        return new DynamicHello(environmentLoc.getProperty("app.hello.prefix"),
                                environmentLoc.getProperty("app.goodbye.prefix"));
    }

}
