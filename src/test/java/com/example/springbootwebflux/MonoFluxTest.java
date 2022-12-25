package com.example.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<String> stringMono = Mono.just("Monir").log();
        stringMono.subscribe(System.out::println);
    }
    @Test
    public void testMonoWithException(){
        Mono<?> stringMono = Mono.just("Monir")
                .then(Mono.error(new RuntimeException("Unusual exception occured"))).log();
        stringMono.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }
    @Test
    public void testFlux(){
        Flux<String> stringFlux = Flux.just("Monir","Hossain","Bhuiyan")
                .concatWithValues("Java").log();
        stringFlux.subscribe(System.out::println);
    }
}
