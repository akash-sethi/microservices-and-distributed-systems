package com.ms.customer.business

import com.ms.client.fraudcheck.CustomerCheckClient
import com.ms.customer.dto.CustomerDTO
import com.ms.customer.dto.toCustomer
import com.ms.customer.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalStateException

@Service
@Transactional
class CustomerService(
    val customerRepository: CustomerRepository,
    val customerCheckClient: CustomerCheckClient
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    fun registerCustomer(customerDTO: CustomerDTO){
        logger.info("registerCustomer => customerDTO = $customerDTO")

        val customer = customerRepository.saveAndFlush(customerDTO.toCustomer())

        val ( isFraudulentCustomer ) = customerCheckClient.isFraudster(customer.id!!.toInt())
        logger.info("isFraudulentCustomer = $isFraudulentCustomer")

        if (isFraudulentCustomer) throw IllegalStateException("The customer is not allowed")
    }
}
