package training.spring.springtraining;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class PersonCredentials {
    @Column(name = "entry_name")
    private String username;
    @Column(name = "entry_id")
    private String password;
    @Column(name = "entry_value")
    private String role;
}
