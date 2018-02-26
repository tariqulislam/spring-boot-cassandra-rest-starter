package com.appstarter.kit.admin.service;

import com.appstarter.kit.admin.domain.Customer;
import com.appstarter.kit.admin.repository.CustomerRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

import static com.appstarter.kit.admin.constraint.Keywords.DATA;
import static com.appstarter.kit.admin.constraint.Keywords.TOTAL;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Map<String, Object> getAllCustomers() {
        try {
           List<Customer> customers =StreamSupport.stream(customerRepository.findAll().spliterator(), true)
                    .collect(Collectors.toList());

           Optional.ofNullable(customers).orElseThrow(() -> new NullPointerException());
          Integer totalCustomer = Optional.ofNullable(customers).map(List::size).orElseThrow(() -> new NullPointerException());
          return ImmutableMap.of(DATA, customers, TOTAL, totalCustomer);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (NoSuchElementException ex) {
            throw ex;
        }
    }


    public Map<String, Object> getCustomerByStatus(Integer age) {
        try {
            Optional<List<Customer>> lstCustomers = Optional.ofNullable(customerRepository.getCustomerByAge(age));
            lstCustomers.orElseThrow(() -> new NullPointerException());
            Integer totalCustomers = lstCustomers.map(List::size).orElseThrow(()-> new NoSuchElementException());
            return ImmutableMap.of(DATA,lstCustomers, TOTAL, totalCustomers);
        }catch (NullPointerException ex) {
            throw  ex;
        } catch (NoSuchElementException ex) {
            throw  ex;
        }


    }
}
