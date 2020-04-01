package com.lang.card.engcard.dao

import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.dto.CardMongoRepository
import org.bson.types.ObjectId

class CardDaoImp(private val repository: CardMongoRepository) : ICardDao {

    override fun addCard(card: CardDto): CardDto {
        val id = ObjectId()
        card.id = id.toString()
        return repository.save(card)
    }

    override fun updateCard(card: CardDto) {
        repository.save(card)
    }

    override fun getRandomCards(): List<CardDto> {
        val cards = repository.findAll()
        return cards.shuffled()
    }

    override fun getCardByTag(tag: String) : List<CardDto> {
        return emptyList()
    }
}