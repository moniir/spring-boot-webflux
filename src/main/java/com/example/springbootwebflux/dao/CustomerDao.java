package com.example.springbootwebflux.dao;

import com.example.springbootwebflux.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerDao {

    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1,50)
                .peek(CustomerDao::sleepExecution)
                .peek(i-> System.out.println("Processing count : "+i))
                .mapToObj(i-> new Customer(i,"Customer"+i)).collect(Collectors.toList());
    }
    public Flux<Customer> getCustomerStream() {
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("Processing count: "+i))
                .map(i-> new Customer(i,"customer"+i));
    }
}
