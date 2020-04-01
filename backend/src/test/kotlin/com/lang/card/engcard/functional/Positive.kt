package com.lang.card.engcard.functional

import com.lang.card.engcard.config.MongoConfig
import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.service.CardService
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import javax.annotation.PostConstruct

@Import(MongoConfig::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class Positive(val service: CardService, val mongoClient: MongoClient) {

    var db: MongoDatabase? = null

    @PostConstruct
    fun setUp() {
        db = mongoClient.getDatabase("test")
    }

    @Test
    fun test() {
        val card = CardDto("test", "тест")
        val id = service.addCard(card).id
        val recivedCard = db
    }

}