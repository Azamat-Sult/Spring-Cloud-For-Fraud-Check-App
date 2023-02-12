package ru.antifraud.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.antifraud.clients.fraudchecker.FraudClient;
import ru.antifraud.clients.fraudchecker.dto.FraudCheckResponse;
import ru.antifraud.customer.dto.CustomerRegistrationRequest;
import ru.antifraud.customer.model.Customer;
import ru.antifraud.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }

}