package training.spring.springtraining;

// Pascal   PersonManager -- Class names
// Camel    personManager -- field and method names
// snake    person_manager -- property file
// kebab    person-manager -- property file

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @RequiredArgsConstructor
@Table(name = "human")
@SecondaryTable(name = "kisi")
@SequenceGenerator(name = "person_seq", allocationSize = 1, sequenceName = "person_seq")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private Long              personId;
    @Column(name = "name", nullable = false, length = 50, table = "kisi")
    private String            firstName;
    @Column(name = "surname", nullable = false, length = 50, table = "kisi")
    private String            lastName;
    @Column(name = "age")
    private Integer           age;
    @Column(name = "height")
    private Integer           height;
    @Column(name = "weight")
    private Integer           weight;
    @Embedded
    private PersonCredentials personCredentials;
    @JsonIgnoreProperties({"hibernateLazyInitializer",
                           "handler"
    })
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Address           address;


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
