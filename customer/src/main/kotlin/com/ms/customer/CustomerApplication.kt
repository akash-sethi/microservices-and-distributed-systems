package com.ms.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(
    scanBasePackages = [
        "com.ms.customer",
        "com.ms.amqp"
    ]
)
@EnableFeignClients(
    basePackages = ["com.ms.client"]
)
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}
