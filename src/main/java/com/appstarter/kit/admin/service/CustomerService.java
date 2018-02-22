package com.appstarter.kit.admin.service;

import com.appstarter.kit.admin.domain.Customer;
import com.appstarter.kit.admin.repository.CustomerRepository;

import java.util.*;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Map<String, Object> getAllCustomers() {
        try {
          Optional<List<Customer>> customers = Optional.ofNullable((List<Customer>)customerRepository.findAll());
          customers.orElseThrow(()->  new NullPointerException() );
          Integer totalCustomer = customers.map(List::size).orElseThrow(() -> new NoSuchElementException());
          return ImmutableMap.of("data", customers, "total", totalCustomer);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (NoSuchElementException ex) {
            throw ex;
        }
    }
}
