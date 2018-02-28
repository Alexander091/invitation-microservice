package com.example.micro.sumbiting.submitingemail.jms;

import com.example.micro.sumbiting.submitingemail.model.SimpleModel;
import com.example.micro.sumbiting.submitingemail.utils.EmailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
@Slf4j
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(SimpleModel model) {
        try {
            EmailUtils.send(model.getEmail(), model.getDate());
        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
        }
        System.out.println("Received <" + model + ">");
    }

}
