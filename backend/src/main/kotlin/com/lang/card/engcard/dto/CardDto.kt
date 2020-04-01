package com.lang.card.engcard.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("eng-card")
data class CardDto(val textOrg: String, val textTransl: String) {
    @Id
    var id: String? = null
    var tags: List<String> = emptyList()
    val description: String? = null
    var errorAttempsCount: Long = 0
    var successfulAttempsCount: Long = 0
    val createDate: Instant? = null
    var lastAttempDate: Instant? = null
}