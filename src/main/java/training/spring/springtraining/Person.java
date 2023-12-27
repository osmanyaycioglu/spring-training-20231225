package training.spring.springtraining;

// Pascal   PersonManager -- Class names
// Camel    personManager -- field and method names
// snake    person_manager -- property file
// kebab    person-manager -- property file

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


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
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 15,message = "firsName 2 ile 15 arasında olmalı")
    private String            firstName;
    @Column(name = "surname", nullable = false, length = 50, table = "kisi")
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 20)
    private String            lastName;
    @Column(name = "age")
    @Max(150)
    @Min(10)
    private Integer           age;
    @Column(name = "height")
    @Max(300)
    @Min(50)
    private Integer           height;
    @Column(name = "weight")
    @Max(300)
    @Min(10)
    private Integer           weight;
    @NotNull
    @Embedded
    private PersonCredentials personCredentials;
    @JsonIgnoreProperties({"hibernateLazyInitializer",
                           "handler"
    })
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Address           address;

    @ElementCollection
    private List<String> nickNames;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Set<Phone> phones;

    private LocalDateTime creationDate;
    private LocalDateTime updateDate;


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

    @PrePersist
    public void beforePersist() {
        System.out.println("Before persist çalıştı");
        creationDate = LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate() {
        System.out.println("Before update çalıştı");
        updateDate = LocalDateTime.now();
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    @PostLoad
    public void after() {

    }

}
