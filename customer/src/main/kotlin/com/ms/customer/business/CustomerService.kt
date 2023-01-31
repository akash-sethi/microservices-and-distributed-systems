package com.ms.customer.business

import com.ms.customer.dto.CustomerDTO
import com.ms.customer.dto.FraudCheckResponse
import com.ms.customer.dto.toCustomer
import com.ms.customer.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestTemplate
import java.lang.IllegalStateException

@Service
@Transactional
class CustomerService(
    val customerRepository: CustomerRepository,
    val restTemplate: RestTemplate
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    fun registerCustomer(customerDTO: CustomerDTO){
        logger.info("registerCustomer => customerDTO = $customerDTO")
        val customer = customerRepository.saveAndFlush(customerDTO.toCustomer())
        //basic communication between two microservice
        val isFraudulentCustomer = restTemplate.getForObject(
            "http://localhost:8081/api/v1/fraud-check/{customerId}",
            FraudCheckResponse::class.java,
            customer.id
        )?.isFraudulentCustomer

        logger.info("isFraudulentCustomer = $isFraudulentCustomer")

        if (isFraudulentCustomer!!) throw IllegalStateException("This email is not allowed")
    }
}
