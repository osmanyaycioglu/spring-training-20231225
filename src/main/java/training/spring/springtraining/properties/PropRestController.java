package training.spring.springtraining.properties;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prop")
@RequiredArgsConstructor
public class PropRestController {
    private final MyAppProperties myAppProperties;


    @GetMapping("/get")
    public MyAppProperties get() {
        return myAppProperties;
    }


}
