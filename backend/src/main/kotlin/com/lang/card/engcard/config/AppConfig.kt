package com.lang.card.engcard.config

import com.lang.card.engcard.dao.CardDaoImp
import com.lang.card.engcard.dto.CardMongoRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun cardDao(cardMongoRepository: CardMongoRepository) = CardDaoImp(cardMongoRepository)

}