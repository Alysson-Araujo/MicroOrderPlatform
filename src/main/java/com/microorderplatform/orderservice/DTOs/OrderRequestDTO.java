package com.microorderplatform.orderservice.DTOs;

import com.microorderplatform.orderservice.models.ItemOrder;

import java.math.BigDecimal;
import java.util.List;


public record OrderRequestDTO(String userId,
                              BigDecimal totalPayment,
                              List<ItemOrder> items) {
}