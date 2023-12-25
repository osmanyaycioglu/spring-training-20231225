package training.spring.springtraining.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import training.spring.springtraining.Person;
import training.spring.springtraining.beans.PersonPrinterServiceReal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/first")
public class MyFirstRestController {
    private final PersonPrinterServiceReal personPrinterServiceReal;

    @GetMapping("/hello")
    public String method(){
        return "Hello world";
    }

    @PostMapping("/hello/person")
    public String method(@RequestBody Person personParam){
        return "Hello person : " + personParam;
    }

}
