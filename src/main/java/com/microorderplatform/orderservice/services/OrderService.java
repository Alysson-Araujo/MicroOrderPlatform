package com.microorderplatform.orderservice.services;


import com.microorderplatform.orderservice.enums.StatusOrderEnum;
import com.microorderplatform.orderservice.models.documents.OrderDocument;
import com.microorderplatform.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;



    public OrderDocument saveOrder(OrderDocument orderDocument) {
        return orderRepository.save(orderDocument);
    }


    @Transactional
    public OrderDocument updateOrderStatus(String orderId, StatusOrderEnum newStatus) {

        OrderDocument orderDocument = orderRepository.findById(orderId).orElse(null);
        if (orderDocument != null) {
            orderDocument.setStatus(newStatus);
            return orderRepository.save(orderDocument);
        }
        return null;
    }

}
