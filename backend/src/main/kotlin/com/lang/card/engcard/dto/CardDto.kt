package com.lang.card.engcard.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class CardDto (
        @Id
        var id: String?,
        val textOrg: String,
        val textTransl: String,
        var tags: List<String> = emptyList(),
        val description: String?,
        var errorAttempsCount: Long = 0,
        var successfulAttempsCount: Long = 0,
        val createDate: Instant?,
        var lastAttempDate: Instant?
)