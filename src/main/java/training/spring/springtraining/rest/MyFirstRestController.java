package training.spring.springtraining.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import training.another.packages.MyAnotherBean;
import training.spring.springtraining.Person;
import training.spring.springtraining.beans.PersonPrinterServiceReal;
import training.spring.springtraining.db.IAddressRepository;
import training.spring.springtraining.db.IPersonRepository;
import training.spring.springtraining.db.PersonJpaRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/first")
public class MyFirstRestController {
    private final PersonPrinterServiceReal personPrinterServiceReal;
    private final MyAnotherBean            myAnotherBean;
    private final IPersonRepository        personRepository;
    private final IAddressRepository       addressRepository;
    private final PersonJpaRepository      personJpaRepository;

    @GetMapping("/hello")
    public String method() {
        return "Hello world";
    }

    @GetMapping("/other/hello")
    public String method2() {
        return this.myAnotherBean.execute();
    }

    @PostMapping("/hello/person")
    public String method(@RequestBody final Person personParam) {
        // addressRepository.save(personParam.getAddress());
        personParam.getAddress()
                   .setPerson(personParam);
        personParam.getPhones()
                   .forEach(phone -> phone.setPerson(personParam));
        this.personRepository.save(personParam);
        return "Hello person : " + personParam;
    }

    @PostMapping("/hello/person2")
    public String method2(@RequestBody final Person personParam) {
        this.personJpaRepository.insert(personParam);
        return "Hello person : " + personParam;
    }

    @GetMapping("/get/one/person")
    public Person getPerson(@RequestParam Long person) {
        return personRepository.findById(person)
                               .orElse(null);
    }

}
