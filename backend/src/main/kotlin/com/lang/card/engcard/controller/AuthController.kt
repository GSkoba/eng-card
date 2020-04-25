package com.lang.card.engcard.controller

import com.lang.card.engcard.dto.AuthDto
import com.lang.card.engcard.dto.LoginDto
import com.lang.card.engcard.dto.UserDto
import com.lang.card.engcard.service.AuthorizationService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
@Api(description = "Controller for login or register")
class AuthController(val authorizationService: AuthorizationService) {

    @PostMapping("/reg")
    @ApiOperation("Registration new user")
    fun reg(@RequestBody user: UserDto): ResponseEntity<AuthDto> {
        val header = authorizationService.registration(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(AuthDto(header))
    }

    @PostMapping("/login")
    @ApiOperation("Login user")
    fun login(@RequestBody user: UserDto): ResponseEntity<AuthDto> {
        val header = authorizationService.login(user)
        return ResponseEntity.ok().body(AuthDto(header))
    }
}