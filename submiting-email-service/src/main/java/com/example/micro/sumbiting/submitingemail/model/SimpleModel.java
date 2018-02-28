package com.example.micro.sumbiting.submitingemail.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class SimpleModel {
    private Date date;
    private String email;
}
