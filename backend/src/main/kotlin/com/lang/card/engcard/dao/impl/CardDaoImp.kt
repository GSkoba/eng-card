package com.lang.card.engcard.dao.impl

import com.lang.card.engcard.dao.ICardDao
import com.lang.card.engcard.dto.CardDto
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.and
import com.mongodb.client.model.Filters.eq
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

    override fun getRandomCards(): List<CardDto> = collection.find().limit(10).shuffled()

    override fun getAllCards(): List<CardDto> = collection.find().toList()

    override fun getCardByTag(tag: String): List<CardDto> {
        TODO("card by tag")
    }

    override fun exist(card: CardDto) =
            collection.find(and(eq("textOrg", card.textOrg), eq("textTransl", card.textTransl)))
                    .toList().isNotEmpty()

    override fun getCard(cardId: String): CardDto {
        return collection.find(eq("_id", cardId)).first()
    }
}