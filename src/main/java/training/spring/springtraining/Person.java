package training.spring.springtraining;

// Pascal   PersonManager -- Class names
// Camel    personManager -- field and method names
// snake    person_manager -- property file
// kebab    person-manager -- property file

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @RequiredArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long    personId;
    private String  firstName;
    private String  lastName;
    private Integer age;
    private Integer height;
    private Integer weight;

    public Person(final String firstNameParam,
                  final String lastNameParam,
                  final Integer ageParam,
                  final Integer heightParam,
                  final Integer weightParam) {
        firstName = firstNameParam;
        lastName  = lastNameParam;
        age       = ageParam;
        height    = heightParam;
        weight    = weightParam;
    }

    public String sayHello() {
        return "Hello : " + firstName + " " + lastName;
    }

}
