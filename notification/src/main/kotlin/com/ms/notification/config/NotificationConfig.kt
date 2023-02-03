package com.ms.notification.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(NotificationConfigProperties::class)
class NotificationConfig(
    val properties: NotificationConfigProperties
) {

    @Bean
    fun topicExchange(): TopicExchange = TopicExchange(properties.internalExchange)

    @Bean
    fun notificationQueue(): Queue = Queue(properties.notificationQueue)

    @Bean
    fun exchangeBinding(notificationQueue: Queue, topicExchange: TopicExchange): Binding =
        BindingBuilder
            .bind(notificationQueue)
            .to(topicExchange)
            .with(properties.internalNotificationRoutingKey)
}
