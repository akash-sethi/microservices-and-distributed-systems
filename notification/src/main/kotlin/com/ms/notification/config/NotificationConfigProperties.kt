package com.ms.notification.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "rabbitmq")
data class NotificationConfigProperties(
    val internalExchange: String,
    val notificationQueue: String,
    val internalNotificationRoutingKey: String
)
