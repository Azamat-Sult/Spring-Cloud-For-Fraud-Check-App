package ru.antifraud.fraudcheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antifraud.fraudcheck.model.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Long> {
}