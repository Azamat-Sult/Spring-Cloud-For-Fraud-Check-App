package ru.antifraud.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antifraud.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}