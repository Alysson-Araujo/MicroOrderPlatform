package com.microorderplatform.orderservice.repositories;

import com.microorderplatform.orderservice.models.documents.OrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends MongoRepository<OrderDocument, String> {

}
