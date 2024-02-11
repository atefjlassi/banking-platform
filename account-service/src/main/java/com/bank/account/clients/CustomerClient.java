package com.bank.account.clients;

import com.bank.account.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

/**
 * interface, proxy
 */
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {


    /**
     * * @param id
     * @return
     *
     * the framework send the request to the customer service directly
     * Using discovery service.
     * (through the name (CUSTOMER-SERVICE) , give me the address of customer-service)
     */
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);


    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    List<Customer> findAll();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not available");
        customer.setLastName("Not available");
        customer.setEmail("Not available");

        return customer;
    }

    default List<Customer> getAllCustomers(Long id, Exception exception) {
        return Collections.emptyList();
    }

}
