package training.spring.springtraining;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Phone {

    @Id
    @GeneratedValue
    private Long phoneId;
    private String phoneName;
    private String phoneNumber;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Person person;

}
