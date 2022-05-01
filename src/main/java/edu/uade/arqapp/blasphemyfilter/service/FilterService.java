package edu.uade.arqapp.blasphemyfilter.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;

import edu.uade.arqapp.blasphemyfilter.domain.Message;

@Service
public class FilterService {

    private Collection<String> PROFANITIES = Arrays.asList(
        "ass"
    );

    public Message filteringMsg(Message message) {
        
        String filter = message.getMessage().toLowerCase();
        Message response = new Message(message);

        // Check for bad words
        for (String badWord : PROFANITIES) {
            if (filter.contains(badWord)) {
                filter = filter.replace(badWord, "****");
                response.setBlasphemy(true);
            }
        }

        response.setMessage(filter);
        return response;
    }

}
