package com.example.springbootwebflux.service;

import com.example.springbootwebflux.model.MultiplyRequestDto;
import com.example.springbootwebflux.model.Response;
import com.example.springbootwebflux.sleepUtil.SleepUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class MathCalculationReactiveService {

    public Mono<Response> findSquare(int input){
        return Mono.fromSupplier(()->input*input)
                .map(v-> new Response(v));
    }

    public Flux<Response> multiplicationTable(int input) {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1)) //here delayElement causes subscriber cancel anytime.
                .doOnNext(i-> System.out.println("reactive-math-service-processing: "+i))
                .map(i->new Response(i*input));
    }
    public Mono<Response> multiply(Mono<MultiplyRequestDto> dtoMono){
        return dtoMono
                .map(dto -> dto.getFirst() * dto.getSecond())
                .map(Response::new);
    }

}
