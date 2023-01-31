package com.ms.client.fraudcheck

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("fraud-check")
interface CustomerCheckClient {

    @GetMapping(path = ["api/v1/fraud-check/{customerId}"])
    fun isFraudster(@PathVariable customerId: Int): CustomerCheckResponse

}
