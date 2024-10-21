package com.microorderplatform.orderservice.configs.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RabbitMQConfiguration {

    // exchanges
    @Value("${rabbitmq.exchange.order}")
    private String orderExchange;

    @Value("${rabbitmq.exchange.payment}")
    private String paymentExchange;

    //Not used in this version
    @Value("${rabbitmq.exchange.log}")
    private String logExchange;


    // queues
    @Value("${rabbitmq.queue.order.created}")
    private String orderCreatedQueue;

    @Value("${rabbitmq.queue.inventory.confirmed}")
    private String inventoryConfirmedQueue;

    @Value("${rabbitmq.queue.payment.success}")
    private String paymentSuccessQueue;

    //Keys

    @Value("${rabbitmq.routing.key.order.created}")
    private String orderCreatedRoutingKey;

    @Value("${rabbitmq.routing.key.inventory.confirmed}")
    private String inventoryConfirmedRoutingKey;

    @Value("${rabbitmq.routing.key.payment.success}")
    private String paymentSuccessRoutingKey;

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(orderExchange);
    }

    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange(paymentExchange);
    }

    //Not used in this version
    @Bean
    public TopicExchange logExchange() {
        return new TopicExchange(logExchange);
    }

    @Bean
    public Queue orderCreatedQueue() {
        return new Queue(orderCreatedQueue);
    }

    @Bean
    public Queue inventoryConfirmedQueue() {
        return new Queue(inventoryConfirmedQueue);
    }

    @Bean
    public Queue paymentSuccessQueue() {
        return new Queue(paymentSuccessQueue);
    }

    // Bindings
    @Bean
    public Binding orderCreatedBinding() {
        return BindingBuilder.bind(orderCreatedQueue()).to(orderExchange()).with(orderCreatedRoutingKey);
    }

    @Bean
    public Binding inventoryConfirmedBinding() {
        return BindingBuilder.bind(inventoryConfirmedQueue()).to(orderExchange()).with(inventoryConfirmedRoutingKey);
    }

    @Bean
    public Binding paymentSuccessBinding() {
        return BindingBuilder.bind(paymentSuccessQueue()).to(paymentExchange()).with(paymentSuccessRoutingKey);
    }


}
