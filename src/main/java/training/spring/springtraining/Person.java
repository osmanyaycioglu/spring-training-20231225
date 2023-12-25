package training.spring.springtraining;

// Pascal   PersonManager -- Class names
// Camel    personManager -- field and method names
// snake    person_manager -- property file
// kebab    person-manager -- property file

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
// @RequiredArgsConstructor
public class Person {
    private String  firstName;
    private String  lastName;
    private Integer age;
    private Integer height;
    private Integer weight;


    public String sayHello() {
        return "Hello : " + firstName + " " + lastName;
    }

}
