package edu.uade.arqapp.blasphemyfilter.controllers;

import edu.uade.arqapp.blasphemyfilter.domain.Message;
import edu.uade.arqapp.blasphemyfilter.service.FilterService;

import com.google.gson.Gson;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson g = new Gson();

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody Message request) {
        kafkaTemplate.send("spring-logs", "Triggered endpoint with message: " + g.toJson(request));
        System.out.println("Triggered endpoint with message: " + g.toJson(request));

        Message message = new Message(request.getUserId(), FilterService.getCensoredText(request.getMessage()));

        String response = g.toJson(message);

        System.out.println(response);

        // kafkaTemplate.send("output", response);
    }

}
