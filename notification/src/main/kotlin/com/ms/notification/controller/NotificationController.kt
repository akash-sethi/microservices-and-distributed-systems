package com.ms.notification.controller

import com.ms.client.notification.NotificationRequest
import com.ms.notification.repository.NotificationRepository
import com.ms.notification.utils.toNotification
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/notifications")
class NotificationController(
    val repository: NotificationRepository
) {

    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    @PostMapping
    fun sendNotification(@RequestBody request: NotificationRequest) {
        logger.info("sendNotification => message = $request")
        repository.save(request.toNotification())
    }

}
