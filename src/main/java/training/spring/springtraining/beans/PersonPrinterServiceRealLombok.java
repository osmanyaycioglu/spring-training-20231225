package training.spring.springtraining.beans;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.spring.springtraining.PersonManager;

@Service
@RequiredArgsConstructor
public class PersonPrinterServiceRealLombok {
    private final PersonManager personManager;

}
