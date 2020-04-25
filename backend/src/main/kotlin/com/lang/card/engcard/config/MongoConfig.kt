package com.lang.card.engcard.config

import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.dto.UserDto
import com.mongodb.MongoClient
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoConfig {

    @Bean
    fun mongoClient(@Value("\${mongodb.uri}") uri: String) = MongoClient(uri)

    @Bean
    fun mongoDB(mongoClient: MongoClient) = mongoClient.getDatabase("eng-card")

    @Bean
    fun codecRegistry() = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()))

    @Bean
    fun cardsColl(mongoDB: MongoDatabase, codecRegistry: CodecRegistry) : MongoCollection<CardDto> =
            mongoDB.getCollection("cards", CardDto::class.java).withCodecRegistry(codecRegistry)

    @Bean
    fun userColl(mongoDB: MongoDatabase, codecRegistry: CodecRegistry) : MongoCollection<UserDto> =
            mongoDB.getCollection("user", UserDto::class.java).withCodecRegistry(codecRegistry)
}