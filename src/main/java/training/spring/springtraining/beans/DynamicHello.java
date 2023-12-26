package training.spring.springtraining.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DynamicHello implements IHello {
    private String helloPrefix;
    private String goodbyePrefix;

    public DynamicHello(@Value("${app.hello.prefix}") final String helloPrefixParam,
                        @Value("${app.goodbye.prefix}") final String goodbyePrefixParam) {
        helloPrefix   = helloPrefixParam;
        goodbyePrefix = goodbyePrefixParam;
    }

    @Override
    public String sayHello(final String name,
                           final String surname) {
        return helloPrefix + " " + name + " " + surname;
    }

    @Override
    public String sayGoodbye(final String name,
                             final String surname) {
        return goodbyePrefix + " " + name + " " + surname;
    }
}
