package ru.antifraud.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.antifraud.clients.fraudchecker.FraudCheckResponse;
import ru.antifraud.clients.fraudchecker.FraudClient;
import ru.antifraud.clients.notification.NotificationClient;
import ru.antifraud.clients.notification.NotificationRequest;
import ru.antifraud.customer.dto.CustomerRegistrationRequest;
import ru.antifraud.customer.model.Customer;
import ru.antifraud.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

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

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Fraud Checker...", customer.getFirstName())
        );

        notificationClient.sendNotification(notificationRequest);

    }

}