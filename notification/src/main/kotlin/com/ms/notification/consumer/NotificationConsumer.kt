package com.ms.notification.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.ms.client.notification.NotificationRequest
import com.ms.notification.repository.NotificationRepository
import com.ms.notification.utils.toNotification
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class NotificationConsumer(
    val repository: NotificationRepository,
) {

    companion object {
        val mapper = ObjectMapper().registerKotlinModule()
    }

    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    @RabbitListener(queues = ["\${rabbitmq.notificationQueue}"])
    fun consumer(message: String) {
        logger.info("sendNotification => message = $message")
        val request = mapper.readValue(message, NotificationRequest::class.java)
        repository.save(request.toNotification())
    }

}
