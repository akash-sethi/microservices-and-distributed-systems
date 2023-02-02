package com.ms.customer.business

import com.ms.client.fraudcheck.CustomerCheckClient
import com.ms.client.notification.NotificationClient
import com.ms.customer.dto.CustomerDTO
import com.ms.customer.dto.toCustomer
import com.ms.customer.dto.toNotificationRequest
import com.ms.customer.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomerService(
    val customerRepository: CustomerRepository,
    val customerCheckClient: CustomerCheckClient,
    val notificationClient: NotificationClient
) {
    private val logger by lazy { LoggerFactory.getLogger(javaClass) }

    companion object {
        const val MESSAGE = """
            Welcome %s, Its so nice to see you as our new customer.
        """
    }

    fun registerCustomer(customerDTO: CustomerDTO) {
        logger.info("registerCustomer => customerDTO = $customerDTO")

        val customer = customerRepository.saveAndFlush(customerDTO.toCustomer())

        val (isFraudulentCustomer) = customerCheckClient.isFraudster(customer.id!!.toInt())
        logger.info("isFraudulentCustomer = $isFraudulentCustomer")

        if (isFraudulentCustomer) throw IllegalStateException("The customer is not allowed")

        val requestDTO = customer.toNotificationRequest(MESSAGE)
        logger.info("Sending async notification request = $requestDTO")
        notificationClient.sendNotification(requestDTO)
    }
}
