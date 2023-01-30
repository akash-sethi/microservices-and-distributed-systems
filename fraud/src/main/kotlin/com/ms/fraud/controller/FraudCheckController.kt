package com.ms.fraud.controller

import com.ms.fraud.business.FraudCheckService
import com.ms.fraud.dto.FraudCheckResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/fraud-check")
class FraudCheckController(
    val fraudCheckService: FraudCheckService
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    @GetMapping(path = ["{customerId}"])
    fun isFraudster(@PathVariable customerId: Int): FraudCheckResponse {
        logger.info("isFraudster => customerId = $customerId")
        return fraudCheckService.isFraudulentCustomer(customerId)
    }
}
