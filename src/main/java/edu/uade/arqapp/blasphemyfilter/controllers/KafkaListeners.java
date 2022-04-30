package edu.uade.arqapp.blasphemyfilter.controllers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    

    @KafkaListener(topics = "input", groupId = "inputTopic")
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }

}
