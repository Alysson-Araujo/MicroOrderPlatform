package com.microorderplatform.orderservice.utils.order;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@EnableMongoAuditing
public abstract class BaseModel {

    @CreatedDate
    @Field("dateOrderCreatedAt")
    private LocalDateTime dateOrderCreatedAt;

    @LastModifiedDate
    @Field("dateOrderUpdatedAt")
    private LocalDateTime dateOrderUpdatedAt;
}
