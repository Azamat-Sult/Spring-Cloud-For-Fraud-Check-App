package ru.antifraud.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.antifraud.clients.notification.NotificationRequest;
import ru.antifraud.notification.model.Notification;
import ru.antifraud.notification.repository.NotificationRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Fraud Checker")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }

}