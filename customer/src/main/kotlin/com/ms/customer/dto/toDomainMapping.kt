package com.ms.customer.dto

import com.ms.customer.domain.Customer

fun CustomerDTO.toCustomer(): Customer =
    Customer(null, this.firstName, this.lastName, this.email)
