package ru.antifraud.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.antifraud.customer.dto.CustomerRegistrationRequest;
import ru.antifraud.customer.model.Customer;
import ru.antifraud.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.save(customer);
    }

}