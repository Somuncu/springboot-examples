package com.example.exceptionhandler.service;

import com.example.exceptionhandler.entity.Bread;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public String getMessage(Bread bread) {
        return "Got Message";
    }

    public Bread setBread(Bread bread) {
        return bread;
    }
}
