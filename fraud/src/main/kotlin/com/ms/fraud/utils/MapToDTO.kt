package com.ms.fraud.utils

import com.ms.client.fraudcheck.CustomerCheckResponse
import com.ms.fraud.domain.FraudCheckHistory

fun FraudCheckHistory.toDTO(): CustomerCheckResponse =
    CustomerCheckResponse(this.isFraudster)
