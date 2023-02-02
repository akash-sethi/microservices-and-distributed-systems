package com.ms.notification.repository

import com.ms.notification.domain.Notification
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository : JpaRepository<Notification, Int>
