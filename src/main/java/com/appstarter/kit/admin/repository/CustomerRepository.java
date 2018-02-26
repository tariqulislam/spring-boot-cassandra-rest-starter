package com.appstarter.kit.admin.repository;

import com.appstarter.kit.admin.domain.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface CustomerRepository extends CassandraRepository<Customer> {

    List<Customer> getCustomerByAge(Integer age);
}
