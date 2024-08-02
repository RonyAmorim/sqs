package com.rony.sqs.controller;

import com.rony.sqs.dto.MessageDTO;
import com.rony.sqs.producer.SqsProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sqs")
public class SqsController {

    @Autowired
    private SqsProducerService sqsProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO message) {
        sqsProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent: "+ message.content());
    }
}
