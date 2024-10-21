package com.microorderplatform.orderservice.enums;

public enum StatusOrderEnum {
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");


    private final String status;

    StatusOrderEnum(String status) {
        this.status = status;
    }
}
