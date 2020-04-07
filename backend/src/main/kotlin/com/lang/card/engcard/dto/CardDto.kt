package com.lang.card.engcard.dto

import org.bson.types.ObjectId
import java.time.Instant

class CardDto {

    constructor() {}

    constructor(textOrg: String, textTransl: String) {
        this.textOrg = textOrg
        this.textTransl = textTransl
    }

    var id: String? = null
    var textOrg: String = ""
    var textTransl: String = ""
    var tags: List<String> = emptyList()
    var description: String? = null
    var errorAttempsCount: Long = 0
    var successfulAttempsCount: Long = 0
    var createDate: Instant? = null
    var lastAttempDate: Instant? = null
}