package com.lang.card.engcard.service

import com.lang.card.engcard.dao.IUserDao
import com.lang.card.engcard.dto.UserDto
import org.springframework.stereotype.Service

@Service
class UserService(val userDao: IUserDao) {

    fun add(user: UserDto) = userDao.add(user)

    fun getByUP(user: UserDto) = userDao.getByUP(user)
}