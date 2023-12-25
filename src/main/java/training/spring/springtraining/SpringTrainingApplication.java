package training.spring.springtraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringTrainingApplication {

    // field Injection
    // @Autowired
    private PersonManager personManager;

    // Constructor Injection
    // @Autowired
    public SpringTrainingApplication(final PersonManager personManagerParam) {
        personManager = personManagerParam;
    }

    // method injection
    // @Autowired
    public void xyz(PersonManager personManager){

    }

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
