package com.lang.card.engcard.dao

import com.lang.card.engcard.dto.CardDto
import com.mongodb.client.MongoCollection
import org.bson.types.ObjectId
import java.util.function.Consumer

class CardDaoImp(private val collection: MongoCollection<CardDto>) : ICardDao {

    override fun addCard(card: CardDto): CardDto {
        card.id = ObjectId().toString()
        collection.insertOne(card)
        return card
    }

    override fun addCard(cards: List<CardDto>): List<CardDto> {
        cards.forEach(Consumer {
            it.id = ObjectId().toString()
        })
        collection.insertMany(cards)
        return cards
    }

    override fun updateCard(card: CardDto) {
        TODO("update card")
    }

    override fun getRandomCards(): List<CardDto> = collection.find().shuffled()

    override fun getAllCards(): List<CardDto> = collection.find().toList()

    override fun getCardByTag(tag: String) : List<CardDto> {
        return emptyList()
    }
}