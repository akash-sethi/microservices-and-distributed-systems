package com.ms.fraud.repository

import com.ms.fraud.domain.FraudCheckHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FraudCheckRepository: JpaRepository<FraudCheckHistory, Int>
