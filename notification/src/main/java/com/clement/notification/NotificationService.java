package com.clement.notification;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.clement.clients.notification.NotificationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {
	
	private final NotificationRepository notificationRepository;
	
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("clement")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }

}
