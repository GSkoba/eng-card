package com.lang.card.engcard.service

import com.lang.card.engcard.dto.UserDto

interface AuthorizationService {
    fun login(user: UserDto): String
    fun registration(user: UserDto): String
}