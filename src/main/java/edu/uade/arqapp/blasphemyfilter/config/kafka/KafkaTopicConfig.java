package edu.uade.arqapp.blasphemyfilter.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    
    // Topic where logs are consumed
    @Bean
    public NewTopic inputTopic() {
        return TopicBuilder.name("input")
            .build();
    }

    // Topic where logs are produced
    @Bean
    public NewTopic outputTopic() {
        return TopicBuilder.name("output")
            .build();
    }

    // Topic where Spring server logs are produced
    @Bean
    public NewTopic springLogsTopic() {
        return TopicBuilder.name("spring-logs")
            .build();
    }

}
