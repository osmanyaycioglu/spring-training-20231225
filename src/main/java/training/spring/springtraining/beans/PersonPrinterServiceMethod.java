package training.spring.springtraining.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.spring.springtraining.PersonManager;

import javax.annotation.PostConstruct;

@Service
public class PersonPrinterServiceMethod {
    private PersonManager personManager;


    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @Autowired
    public void method(PersonManager personManagerParam) {
        personManager = personManagerParam;
    }
}
