package com.lang.card.engcard.functional

import com.lang.card.engcard.config.AssertUtilsConfig
import com.lang.card.engcard.config.MongoContainerConfig
import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.utils.AssertUtils
import com.mongodb.client.MongoCollection
import org.bson.types.ObjectId
import org.junit.Ignore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = arrayOf(MongoContainerConfig::class, AssertUtilsConfig::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CardControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    lateinit var collection: MongoCollection<CardDto>

    @Autowired
    lateinit var assertUtils: AssertUtils

    @BeforeEach
    fun clear() {
        collection.drop()
    }

    @Test
    fun `add card`() {
        val card = CardDto("dog", "песя")
        val resp = restTemplate.postForEntity(
            "/cards/add", card,
            CardDto::class.java
        )
        assertNotNull(resp) { "Response from server must not be null" }
        assertEquals(resp.statusCode, HttpStatus.OK) { "Response status must eq ok (200)" }
        assertNotNull(resp.body) { "Body must not be null" }
        assertUtils.assertWithoutId(listOf(card), listOf(resp.body) as List<CardDto>)
    }

    @Test
    fun `get random cards from server`() {
        val card = CardDto("rock", "камень")
        card.id = ObjectId().toString()
        collection.insertOne(card)
        val resp = restTemplate.exchange(
            "/cards/rand", HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<CardDto>>() {}
        )
        assertNotNull(resp) { "Response from server must not be null" }
        assertEquals(resp.statusCode, HttpStatus.OK) { "Response status must eq ok (200)" }
        assertNotNull(resp.body) { "Body must not be null" }
        assertUtils.assertWithoutId(listOf(card), resp.body as List<CardDto>)
    }

//    @Test
//    @Ignore - dont work
//    fun `get cards by tag`() {
//        TODO("test get cards by tag")
//    }

//    @Test
//    @Ignore
//    fun `update card`() {
//        TODO("test update card")
//    }

    @Test
    fun `get cards from server`() {
        val card = CardDto("sun", "солнце")
        card.id = ObjectId().toString()
        collection.insertOne(card)
        val resp = restTemplate.exchange(
            "/cards/all", HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<CardDto>>() {}
        )
        assertNotNull(resp)
        assertEquals(resp.statusCode, HttpStatus.OK) { "Response status must eq ok (200)" }
        assertNotNull(resp.body) { "Body must not be null" }
        assertUtils.assertWithoutId(listOf(card), resp.body as List<CardDto>)
    }

    @Test
    fun `get cards from server by id`() {
        val card = CardDto("cat", "котэ")
        card.id = ObjectId().toString()
        collection.insertOne(card)
        val resp = restTemplate.exchange(
            "/cards/${card.id}", HttpMethod.GET, null,
            object : ParameterizedTypeReference<CardDto>() {}
        )
        assertNotNull(resp)
        assertEquals(resp.statusCode, HttpStatus.OK) { "Response status must eq ok (200)" }
        assertNotNull(resp.body) { "Body must not be null" }
        assertUtils.assertWithoutId(listOf(card), listOf(resp.body) as List<CardDto>)
    }

}