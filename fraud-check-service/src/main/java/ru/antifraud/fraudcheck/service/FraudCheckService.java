package ru.antifraud.fraudcheck.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.antifraud.fraudcheck.model.FraudCheckHistory;
import ru.antifraud.fraudcheck.repository.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}