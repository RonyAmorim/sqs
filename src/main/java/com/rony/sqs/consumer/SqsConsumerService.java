package com.rony.sqs.consumer;

import com.rony.sqs.dto.MessageDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;

@Component
public class SqsConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(SqsConsumerService.class);

    @SqsListener("minha-fila")
    public void listen(@Payload MessageDTO message) {
        logger.info("Message received: " + message.content());
    }
}
