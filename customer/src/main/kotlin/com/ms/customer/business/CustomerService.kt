package com.ms.customer.business

import com.ms.customer.dto.CustomerDTO
import com.ms.customer.dto.toCustomer
import com.ms.customer.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    fun registerCustomer(customerDTO: CustomerDTO){
        logger.info("registerCustomer => customerDTO = $customerDTO")
        customerRepository.save(customerDTO.toCustomer())
    }
}
