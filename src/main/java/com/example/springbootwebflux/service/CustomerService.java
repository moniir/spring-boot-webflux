package com.example.springbootwebflux.service;

import com.example.springbootwebflux.dao.CustomerDao;
import com.example.springbootwebflux.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomers(){
        long starttime = System.currentTimeMillis();
        List<Customer> customerList = customerDao.getCustomers();
        long endTime = System.currentTimeMillis();
        System.out.println("Total processing time: "+(endTime - starttime));
        return customerList;
    }

    public Flux<Customer> getAllCustomerStream(){
        long starttime = System.currentTimeMillis();
        Flux<Customer> customerFlux = customerDao.getCustomerStream();
        long endTime = System.currentTimeMillis();
        System.out.println("Total processing time: "+(endTime - starttime));
        return customerFlux;
    }
}
