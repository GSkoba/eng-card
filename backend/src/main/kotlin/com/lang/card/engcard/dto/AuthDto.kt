package com.lang.card.engcard.dto

data class AuthDto(
        val access_token: String,
        val expires: Long = 36000
)