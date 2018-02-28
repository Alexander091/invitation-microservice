package com.example.micro.sumbiting.submitingemail.controllers;

import com.example.micro.sumbiting.submitingemail.model.SimpleModel;
import com.example.micro.sumbiting.submitingemail.utils.EmailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/email")
@Slf4j
public class SubmitingEmailController {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public SubmitingEmailController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public Mono<Void> submitEmail(@RequestBody SimpleModel model) {
        log.info("submitEmail: {}", model);
        jmsTemplate.convertAndSend("mailbox", model);
        return Mono.empty();
    }
}
