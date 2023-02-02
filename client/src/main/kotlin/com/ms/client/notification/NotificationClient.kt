package com.ms.client.notification

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("notification")
interface NotificationClient {

    @PostMapping("api/v1/notifications")
    fun sendNotification(@RequestBody request: NotificationRequest)
}
