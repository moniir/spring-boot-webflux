package com.example.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<String> stringMono = Mono.just("Monir").log();
        stringMono.subscribe(System.out::println);
    }
}
