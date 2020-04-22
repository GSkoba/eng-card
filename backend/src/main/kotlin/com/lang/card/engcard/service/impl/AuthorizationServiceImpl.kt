package com.lang.card.engcard.service.impl

import com.lang.card.engcard.dto.UserDto
import com.lang.card.engcard.service.AuthorizationService
import com.lang.card.engcard.service.UserService
import org.springframework.stereotype.Service
import org.springframework.util.Base64Utils

@Service
class AuthorizationServiceImpl(val userService: UserService) : AuthorizationService {

    override fun login(user: UserDto): String {
        if (userService.getByUP(user) != null) {
            return getBasicHeader(user.username, user.password)
        }
        return ""
    }

    override fun registration(user: UserDto): String = login(userService.add(user))

    fun getBasicHeader(userName: String, password: String) =
            Base64Utils.encodeToString("$userName:$password".toByteArray())
}