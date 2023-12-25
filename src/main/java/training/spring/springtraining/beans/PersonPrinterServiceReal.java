package training.spring.springtraining.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.spring.springtraining.PersonManager;

@Service
public class PersonPrinterServiceReal {
    private final PersonManager personManager;

//    public PersonPrinterServiceReal(final PersonManager personManagerParam) {
//        personManager = personManagerParam;
//        // System.out.println("init");
//    }

    public PersonPrinterServiceReal(final PersonManager personManagerParam,
                                    String str) {
        personManager = personManagerParam;
    }

    @Autowired
    public PersonPrinterServiceReal(PersonManager personManager) {
        this.personManager = personManager;
    }
}
