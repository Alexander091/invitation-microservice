package com.example.micro.mainview.mainview.controllers;

import com.example.micro.mainview.mainview.model.SimpleModel;
import com.example.micro.mainview.mainview.proxy.EmailSubmitingServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invitation")
@Slf4j
public class MainController {

    @Autowired
    private final EmailSubmitingServiceProxy proxy;

    public MainController(EmailSubmitingServiceProxy proxy) {
        this.proxy = proxy;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public ResponseEntity<Object> submitInvitation(@RequestBody SimpleModel model) {
        log.info("Date meeting: {}, email: {}", model.getDate(), model.getEmail());
        proxy.submitEmail(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> fallbackMethod() {
        log.info("Something happened");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
