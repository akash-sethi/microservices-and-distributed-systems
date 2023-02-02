package com.ms.customer.dto

import com.ms.client.notification.NotificationRequest
import com.ms.customer.domain.Customer

fun Customer.toNotificationRequest(message: String): NotificationRequest {
    val fullName = "$firstName $lastName"
    return NotificationRequest(fullName, String.format(message, fullName), email)
}

