package com.example.part2;


import com.example.part2.Customer;
import com.example.part2.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.logging.Logger;

@EnableJpaRepositories(basePackages = "com.example.part2")
@EntityScan(basePackages = "com.example.part2")

@SpringBootApplication
public class Part2Application {

    private static final Logger logger = Logger.getLogger(Part2Application.class.getName());

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Part2Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<Customer> allCustomers = repository.findAll();
        logger.info("Number of customers: " + allCustomers.size());

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        logger.info("Saving new customer...");
        repository.save(newCustomer);

        allCustomers = repository.findAll();
        logger.info("Number of customers: " + allCustomers.size());
    }
}
