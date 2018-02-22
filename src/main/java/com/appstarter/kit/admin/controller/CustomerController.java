package com.appstarter.kit.admin.controller;

import com.appstarter.kit.admin.service.CustomerService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value ="/all" )
    public ResponseEntity<?> getAll() {
       return ResponseEntity.status(200).body(ImmutableMap.of("DATA", customerService.getAllCustomers().get("data")));
    }
}
