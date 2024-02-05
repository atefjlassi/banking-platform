package com.bank.customer;

import com.bank.customer.entities.Customer;
import com.bank.customer.repositories.CustomerRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
    return args -> {
      List<Customer> customerList = List.of(Customer.builder().firstName("Hassan").lastName("Jlassi")
          .email("hassan.jlassi@gmail.com").build(),

        Customer.builder().firstName("Ali").lastName("Ouerteni")
          .email("ali.ouerteni@gmail.com").build()
      );

      customerRepository.saveAll(customerList);
    };
  }
}
