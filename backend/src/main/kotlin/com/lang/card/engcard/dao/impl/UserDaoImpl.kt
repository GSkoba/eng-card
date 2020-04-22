package com.lang.card.engcard.dao.impl

import com.lang.card.engcard.dao.IUserDao
import com.lang.card.engcard.dto.UserDto
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.bson.types.ObjectId

class UserDaoImpl(val userColl: MongoCollection<UserDto>) : IUserDao {

    override fun add(user: UserDto): UserDto {
        val id = ObjectId().toString()
        user.id = id
        userColl.insertOne(user)
        return user
    }

    override fun getByUP(user: UserDto): UserDto? {
        val list = userColl.find(Filters.and(Filters.eq("username", user.username),
                Filters.eq("password", user.password)))
        if (list != null) {
            return list.first()
        }
        return null
    }
}