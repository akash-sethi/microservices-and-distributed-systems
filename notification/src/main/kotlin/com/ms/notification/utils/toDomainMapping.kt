package com.ms.notification.utils

import com.ms.client.notification.NotificationRequest
import com.ms.notification.domain.Notification

fun NotificationRequest.toNotification(): Notification =
    Notification(null, fullName, message, email)
