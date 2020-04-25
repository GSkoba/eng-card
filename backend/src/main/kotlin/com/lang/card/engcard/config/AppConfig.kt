package com.lang.card.engcard.config

import com.lang.card.engcard.dao.impl.CardDaoImp
import com.lang.card.engcard.dao.impl.UserDaoImpl
import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.dto.UserDto
import com.mongodb.client.MongoCollection
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun cardDao(cardsCollection: MongoCollection<CardDto>) = CardDaoImp(cardsCollection)

    @Bean
    fun userDao(userColl: MongoCollection<UserDto>) = UserDaoImpl(userColl)
}