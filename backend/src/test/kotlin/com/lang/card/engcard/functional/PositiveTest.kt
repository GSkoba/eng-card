package com.lang.card.engcard.functional

import com.lang.card.engcard.config.AssertUtilsConfig
import com.lang.card.engcard.config.MongoContainerConfig
import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.service.CardService
import com.lang.card.engcard.utils.AssertUtils
import com.mongodb.client.MongoCollection
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = arrayOf(MongoContainerConfig::class, AssertUtilsConfig::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PositiveTest {

    @Autowired
    lateinit var service: CardService

    @Autowired
    lateinit var collection: MongoCollection<CardDto>

    @Autowired
    lateinit var assertUtils: AssertUtils

    @BeforeEach
    fun drop() {
        collection.drop()
    }

    @Test
    fun `test for send one card to mongo`() {
        val cardDto = CardDto("hello", "привет")
        val receivedCard = service.addCard(cardDto)
        assertNotNull(receivedCard) { "received card must not be null" }
        assertNotNull(receivedCard.id) { "received.id card must not be null" }
        assertEquals(cardDto.textOrg, receivedCard.textOrg) { "receivedCard.textOrg must not be a change" }
        assertEquals(cardDto.textTransl, receivedCard.textTransl) { "receivedCard.textTransl must not be a change" }
    }

    @Test
    fun `test for send many card to mongo`() {
        val listOfCard = arrayListOf(
            CardDto("car", "машина"),
            CardDto("house", "дом"),
            CardDto("cat", "кошка"),
            CardDto("earth", "земля")
        )

        val receivedList = service.addCard(listOfCard)
        assertNotNull(receivedList) { "receivedList must not be null" }
        assertEquals(listOfCard.size, receivedList.size) {
            "receivedList.size must be equals cardList before send to mongo"
        }
        assertUtils.assertWithoutId(listOfCard, receivedList)
    }
}