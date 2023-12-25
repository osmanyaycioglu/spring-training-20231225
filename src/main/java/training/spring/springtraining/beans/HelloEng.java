package training.spring.springtraining.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class HelloEng implements IHello {

    @Override
    public String sayHello(final String name,
                           final String surname) {
        return "Hello " + name + " " + surname;
    }

    @Override
    public String sayGoodbye(final String name,
                             final String surname) {
        return "Goodbye " + name + " " + surname;
    }

}
