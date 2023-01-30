package com.ms.fraud.dto

import com.ms.fraud.domain.FraudCheckHistory

data class FraudCheckResponse(val isFraudulentCustomer: Boolean)

fun FraudCheckHistory.toDTO(): FraudCheckResponse =
    FraudCheckResponse(this.isFraudster)
