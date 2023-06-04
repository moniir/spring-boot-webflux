package com.example.springbootwebflux.controller;

import com.example.springbootwebflux.model.Response;
import com.example.springbootwebflux.service.MathCalculationReactiveService;
import com.example.springbootwebflux.service.MathCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private MathCalculationService mathCalculationService;
    @Autowired
    private MathCalculationReactiveService mathCalculationReactiveService;

    //----------------Simple Calculation Service-----------------
    @GetMapping("/calculate-square/{input}")
    public Response findSquare(@PathVariable int input){
        return this.mathCalculationService.findSquare(input);
    }

    @GetMapping("/table/{input}")
    public List<Response> multiplicationTable(@PathVariable int input){
        return this.mathCalculationService.multiplicationTable(input);
    }


    //--------------Reactive Calculation Service---------------------

    @GetMapping("/square-reactive/{input}")
    public Mono<Response> findSquareReactive(@PathVariable int input){
        return mathCalculationReactiveService.findSquare(input);
    }

    @GetMapping("/table-reactive/{input}")
    public Flux<Response> multiplicationTableReactive(@PathVariable int input){
        return this.mathCalculationReactiveService.multiplicationTable(input);
    }

}
