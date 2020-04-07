package com.lang.card.engcard.functional

import com.lang.card.engcard.config.MongoConfig
import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.service.CardService
import com.mongodb.client.MongoCollection
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.function.Consumer

@SpringBootTest(classes = arrayOf(MongoConfig::class))
class Positive {

    @Autowired
    lateinit var service: CardService

    @Autowired
    lateinit var collection: MongoCollection<CardDto>

    @Before
    fun drop() {
        collection.drop()
    }

    @Test
    fun testAddCard() {
        val cardDto = CardDto("hello", "привет")
        val receivedCard = service.addCard(cardDto)
        assertNotNull(receivedCard)
        assertNotNull(receivedCard.id)
        assertEquals(cardDto.textOrg, receivedCard.textOrg)
        assertEquals(cardDto.textTransl, receivedCard.textTransl)
    }

    @Test
    fun testAddCards() {
        val listOfCard = arrayListOf(
                CardDto("car", "машина"),
                CardDto("house", "дом"),
                CardDto("cat", "кошка"),
                CardDto("earth", "земля")
        )

        val receivedList = service.addCard(listOfCard)
        assertNotNull(receivedList)
        assertEquals(listOfCard.size, receivedList.size)
        assertWithoutId(listOfCard, receivedList)
    }

    private fun assertWithoutId(expected: List<CardDto>, actual: List<CardDto>) {
        val expIterator = expected.sortedBy { it.textOrg }.iterator()
        actual.sortedBy { it.textOrg }.forEach(Consumer {
            assertNotNull(it.id)
            val expCardDto = expIterator.next()
            assertEquals(it.textOrg, expCardDto.textOrg)
            assertEquals(it.textTransl, expCardDto.textTransl)
        })
    }
}