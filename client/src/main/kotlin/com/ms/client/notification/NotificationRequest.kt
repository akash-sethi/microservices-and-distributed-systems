package com.ms.client.notification

data class NotificationRequest(
    val fullName: String,
    val message: String,
    val email: String
)
