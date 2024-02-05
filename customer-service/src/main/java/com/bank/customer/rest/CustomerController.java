package com.bank.customer.rest;

import com.bank.customer.entities.Customer;
import com.bank.customer.repositories.CustomerRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private final CustomerRepository customerRepository;

  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }


  @GetMapping("/customers")
  public List<Customer> customerList() {
      return customerRepository.findAll();
  }


  @GetMapping("/customers/{id}")
  public Customer customerList(@PathVariable("id") Long id) {
    return customerRepository.findById(id).get();
  }
}
