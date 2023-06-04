package com.example.springbootwebflux.service;

import com.example.springbootwebflux.model.Response;
import com.example.springbootwebflux.sleepUtil.SleepUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathCalculationService {

    public Response findSquare(int input){
        return new Response(input*input);
    }

    public List<Response> multiplicationTable(int input){
        return IntStream.rangeClosed(1,10)
                .peek(i->SleepUtil.sleepSeconds(1))
                .peek(i-> System.out.println("Math-service processing :"+i))
                .mapToObj(i-> new Response(i*input))
                .collect(Collectors.toList());
    }

}
