package com.ms.customer.controller

import com.ms.customer.business.CustomerService
import com.ms.customer.dto.CustomerDTO
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(
    val customerService: CustomerService
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    @PostMapping
    fun registerCustomer(@RequestBody customerDTO: CustomerDTO) {
        logger.info("registerCustomer =>? request = $customerDTO")
        customerService.registerCustomer(customerDTO)
    }
}
