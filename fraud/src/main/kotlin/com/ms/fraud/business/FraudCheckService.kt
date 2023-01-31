package com.ms.fraud.business

import com.ms.client.fraudcheck.CustomerCheckResponse
import com.ms.fraud.domain.FraudCheckHistory
import com.ms.fraud.utils.toDTO
import com.ms.fraud.repository.FraudCheckRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional
class FraudCheckService(
    val fraudCheckRepository: FraudCheckRepository
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    fun isFraudulentCustomer(customerId: Int): CustomerCheckResponse {
        logger.info("isFraudulentCustomer => customerId = $customerId")
        //todo check from third party or internal implementation and save the history
        val isFraudster = false
        logger.info("isFraudster = $isFraudster")

        return fraudCheckRepository
            .save(FraudCheckHistory(null, customerId, isFraudster, LocalDateTime.now()))
            .toDTO()
    }
}
