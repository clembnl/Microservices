package com.clement.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clement.clients.notification.NotificationRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {
	
    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }	
    
    @KafkaListener(topics = "customer", groupId = "groupId", containerFactory = "kafkaJsonListenerContainerFactory")
    @GetMapping
	void listener(Customer data) {
		System.out.println("Listener received: " + data);
	}

}
