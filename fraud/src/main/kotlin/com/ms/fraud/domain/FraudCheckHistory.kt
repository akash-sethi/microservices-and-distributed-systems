package com.ms.fraud.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Table(name="fraud_check_histories")
@Entity
class FraudCheckHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val customerId: Int,
    val isFraudster: Boolean,
    val created: LocalDateTime
)
