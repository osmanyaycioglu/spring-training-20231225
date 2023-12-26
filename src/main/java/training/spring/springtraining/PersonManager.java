package training.spring.springtraining;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Qualifier("tr-dili")
@Component
public class PersonManager {
    private List<Person> personList = new ArrayList<>();

    public void addPerson(Person personParam){
        personList.add(personParam);
    }

}
