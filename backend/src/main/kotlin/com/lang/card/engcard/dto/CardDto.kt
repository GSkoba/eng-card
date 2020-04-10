package com.lang.card.engcard.dto

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

    override fun toString(): String {
        return "CardDto(id=$id, textOrg='$textOrg', " +
                "textTransl='$textTransl', tags=$tags," +
                " description=$description, errorAttempsCount=$errorAttempsCount," +
                " successfulAttempsCount=$successfulAttempsCount, createDate=$createDate," +
                " lastAttempDate=$lastAttempDate)"
    }


}