package edu.uade.arqapp.blasphemyfilter.controllers;

import com.google.gson.Gson;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import edu.uade.arqapp.blasphemyfilter.domain.Message;
import edu.uade.arqapp.blasphemyfilter.service.FilterService;

@Component
public class KafkaListeners {

    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson g = new Gson();

    public KafkaListeners(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "input", groupId = "inputTopic")
    void listener(String data) {
        System.out.println("Listener received: " + data);

        Message input = g.fromJson(data, Message.class);

        Message message = new Message(input.getUserId(), FilterService.getCensoredText(input.getMessage()));

        String response = g.toJson(message);

        kafkaTemplate.send("output", response);

    }

}
