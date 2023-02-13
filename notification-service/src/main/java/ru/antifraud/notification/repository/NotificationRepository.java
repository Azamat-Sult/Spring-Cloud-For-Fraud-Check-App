package ru.antifraud.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antifraud.notification.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}