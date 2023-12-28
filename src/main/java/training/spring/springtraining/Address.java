package training.spring.springtraining;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "address_seq", allocationSize = 1, sequenceName = "address_seq")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private Long   addressId;
    @NotEmpty
    private String city;
    private String street;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

}
