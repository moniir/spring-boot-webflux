package com.example.springbootwebflux.controller;

import com.example.springbootwebflux.exception.InputValidationException;
import com.example.springbootwebflux.model.MultiplyRequestDto;
import com.example.springbootwebflux.model.Response;
import com.example.springbootwebflux.service.MathCalculationReactiveService;
import com.example.springbootwebflux.service.MathCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

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
        if(input<10 || input>20){
            throw new InputValidationException(input);
        }
        return this.mathCalculationReactiveService.multiplicationTable(input);
    }

    @PostMapping("multiply")
    public Mono<Response> multiply(@RequestBody Mono<MultiplyRequestDto> requestDtoMono,
                                   @RequestHeader Map<String, String> headers){
        System.out.println(headers);
        return this.mathCalculationReactiveService.multiply(requestDtoMono);
    }

}
