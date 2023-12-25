package training.spring.springtraining.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import training.spring.springtraining.beans.IHello;

@RestController
@RequestMapping("/api/v1/hello")
//@RequiredArgsConstructor
public class HelloRestController {
    private final IHello hello;

    public HelloRestController(@Qualifier("my-hello-tr")  final IHello helloParam) {
        hello = helloParam;
    }

    // /api/v1/hello/say/hello?n=osman&s=yaycıoğlu
    @GetMapping("/say/hello")
    public String hello(@RequestParam("n") final String name,
                        @RequestParam("s") final String surname) {
        return this.hello.sayHello(name,
                                   surname);
    }

    // /api/v1/hello/say/hello2?name=osman&surname=yaycıoğlu
    @GetMapping("/say/hello2")
    public String hello2(@RequestParam final String name,
                         @RequestParam final String surname) {
        return this.hello.sayHello(name,
                                   surname);
    }

    // /api/v1/hello/say/hello3/osman?surname=yaycıoğlu
    @GetMapping("/say/hello3/{name}")
    public String hello3(@PathVariable final String name,
                         @RequestParam final String surname) {
        return this.hello.sayHello(name,
                                   surname);
    }

    // /api/v1/hello/say/goodbye/osman/yaycıoğlu
    @GetMapping("/say/goodbye/{isim}/{soy}")
    public String goodbye(@PathVariable("isim") final String name,
                          @PathVariable("soy") final String surname) {
        return this.hello.sayGoodbye(name,
                                     surname);
    }

    // /api/v1/hello/say/goodbye2/osman/yaycıoğlu
    @GetMapping("/say/goodbye2/{name}/{surname}")
    public String goodbye2(@PathVariable final String name,
                           @PathVariable final String surname) {
        return this.hello.sayGoodbye(name,
                                     surname);
    }

}
