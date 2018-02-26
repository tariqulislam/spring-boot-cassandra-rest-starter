package com.appstarter.kit.admin.controller;

import com.appstarter.kit.admin.service.CustomerService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;

import static com.appstarter.kit.admin.constraint.Keywords.*;
import static org.apache.http.HttpStatus.SC_OK;

@RestController
@RequestMapping(value ="/customers")
public class CustomerController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value ="/all" )
    public ResponseEntity<?> getAll() {
        Map<String, Object> getCustomers= customerService.getAllCustomers();
       return ResponseEntity.status(SC_OK).body(ImmutableMap.of(
               DATA, getCustomers.get("data"),
               MESSAGE, messageSource.getMessage("customer.info.get", new Object[]{}, Locale.US),
               TOTAL, getCustomers.get("total"),
               STATUS, SUCCCESS,
               STATUS_CODE, SC_OK
       ));
    }
}
