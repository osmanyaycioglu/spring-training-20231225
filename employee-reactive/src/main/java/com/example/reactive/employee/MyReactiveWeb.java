package com.example.reactive.employee;

import io.netty.channel.ChannelOption;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;


@RestController
@RequestMapping("/reactive")
public class MyReactiveWeb {

    @GetMapping("/test1")
    public Mono<String> test1() {

        HttpClient httpClientLoc = HttpClient.create()
                                             .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,
                                                     2000);
        WebClient webClientLoc = WebClient.builder()
                                          .clientConnector(new ReactorClientHttpConnector(httpClientLoc))
                                          .defaultHeader("abc",
                                                         "xyz")
                                          .build();
        return webClientLoc.post()
                           .uri("http://127.0.0.1:8080/api/v1/first/hello/person")
                           .body(BodyInserters.fromValue(new Employee("osman",
                                                                      "yaycıoğlu")))

                           .retrieve()
                           .onStatus(HttpStatus::isError,
                                     res -> {
                                         System.out.println("xyz");
                                         return res.bodyToMono(String.class)
                                                   .flatMap(s -> Mono.error(new IllegalStateException(s)));
                                     }
                           )
                           .bodyToMono(String.class)
                           .doOnNext(s -> System.out.println("received :" + s))
                           .flatMap(s -> Mono.just("Diğer taraftan gelen data : " + s))
                ;


    }

}
