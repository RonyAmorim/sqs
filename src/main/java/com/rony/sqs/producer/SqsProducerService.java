package com.rony.sqs.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rony.sqs.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.concurrent.CompletableFuture;

@Service
public class SqsProducerService {

    @Autowired
    private SqsAsyncClient sqsAsyncClient;

    @Autowired
    private ObjectMapper objectMapper;

    private final String queueUrl = "http://localhost:4566/000000000000/minha-fila"; // Ajuste a URL conforme necessário

    public CompletableFuture<Void> sendMessage(MessageDTO message) {
        try {
            String messageContent = objectMapper.writeValueAsString(message);
            SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(messageContent)
                    .build();

            return sqsAsyncClient.sendMessage(sendMessageRequest).thenAccept(response -> {
                // Log the response or handle it como necessário
                System.out.println("Message sent with ID: " + response.messageId());
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return CompletableFuture.failedFuture(e);
        }
    }
}
