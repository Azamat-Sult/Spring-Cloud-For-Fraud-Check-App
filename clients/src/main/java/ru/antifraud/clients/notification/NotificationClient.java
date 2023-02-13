package ru.antifraud.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-service", url = "${clients.notification-service.url}")
public interface NotificationClient {

    @PostMapping(path = "api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);

}