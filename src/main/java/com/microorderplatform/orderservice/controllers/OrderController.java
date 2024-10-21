package com.microorderplatform.orderservice.controllers;


import com.microorderplatform.orderservice.DTOs.OrderRequestDTO;
import com.microorderplatform.orderservice.models.documents.OrderDocument;
import com.microorderplatform.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderDocument> createOrder(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {

        var order = new OrderDocument(orderRequestDTO.userId(), orderRequestDTO.totalPayment(), orderRequestDTO.items());

        return ResponseEntity.ok(orderService.saveOrder(order));

    }
}
