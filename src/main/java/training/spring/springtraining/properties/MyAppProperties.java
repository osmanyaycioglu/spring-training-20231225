package training.spring.springtraining.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import training.spring.springtraining.Person;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "my.app.prop")
@Validated
public class MyAppProperties {
    @NotEmpty
    private String              host;
    private Integer             port;
    private String              appVersion;
    private String              appHeader;
    @NestedConfigurationProperty
    private Person              person;
    private List<String>        personNames;
    private List<Person>        personList;
    private Map<String, Person> personMap;

}
