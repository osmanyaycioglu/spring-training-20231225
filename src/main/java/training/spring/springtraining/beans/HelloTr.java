package training.spring.springtraining.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("selam-tr")
@Qualifier("my-hello-tr")
// @Primary
public class HelloTr implements IHello {

    @Override
    public String sayHello(final String name,
                           final String surname) {
        return "Selam " + name + " " + surname;
    }

    @Override
    public String sayGoodbye(final String name,
                             final String surname) {
        return "Güle güle " + name + " " + surname;
    }

}
