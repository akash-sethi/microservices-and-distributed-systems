package com.ms.amqp

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

@Component
class MessageProducer(
    private val amqpTemplate: AmqpTemplate
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    fun publish(payload: Any, exchange: String, routingKey: String) {
        logger.info("Publishing to $exchange using $routingKey and payload = $payload")
        amqpTemplate.convertAndSend(exchange, routingKey, payload)
        logger.info("<= After Publishing")
    }

}
