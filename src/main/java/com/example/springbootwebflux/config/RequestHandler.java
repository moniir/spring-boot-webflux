package com.example.springbootwebflux.config;

import com.example.springbootwebflux.model.Response;
import com.example.springbootwebflux.service.MathCalculationReactiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestHandler {

    @Autowired
    private MathCalculationReactiveService mathService;

    public Mono<ServerResponse> squareHandler(ServerRequest request){
        Integer input = Integer.parseInt(request.pathVariable("input"));
        Mono<Response> responseBodyMono = this.mathService.findSquare(input);
        return ServerResponse.ok().body(responseBodyMono, Response.class);
    }

    public Mono<ServerResponse> tableHandler(ServerRequest request){
        Integer input = Integer.parseInt(request.pathVariable("input"));
        Flux<Response> responseFlux = this.mathService.multiplicationTable(input);
        return ServerResponse.ok().body(responseFlux,Response.class);
    }
}
