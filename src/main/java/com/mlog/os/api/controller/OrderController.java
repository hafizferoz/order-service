package com.mlog.os.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mlog.os.api.common.TransactionRequest;
import com.mlog.os.api.common.TransactionResponse;
import com.mlog.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        try {
            return service.saveOrder(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
