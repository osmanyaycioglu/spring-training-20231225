package training.spring.springtraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringTrainingApplication {

    @Autowired
    private PersonManager personManager;

    public static void main(String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringTrainingApplication.class,
                                                                          args);

        Person personLoc = new Person("Osman",
                                      "Yaycıoğlu",
                                      54,
                                      200,
                                      100);
        String firstNameLoc = personLoc.getFirstName();

        SpringTrainingApplication beanLoc = contextLoc.getBean(SpringTrainingApplication.class);
        beanLoc.personManager.addPerson(personLoc);

//        PersonManager personManagerLoc = new PersonManager();
//        personManagerLoc.addPerson(personLoc);

    }

}
