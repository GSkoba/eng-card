package com.lang.card.engcard.dao

import com.lang.card.engcard.dto.UserDto

interface IUserDao {

    fun add(user: UserDto): UserDto

    fun getByUP(user: UserDto): UserDto?
}