package com.lang.card.engcard.dao

import com.lang.card.engcard.dto.CardDto

interface ICardDao {

    fun addCard(card: CardDto): CardDto

    fun addCard(cards: List<CardDto>): List<CardDto>

    fun updateCard(card: CardDto)

    fun getRandomCards(): List<CardDto>

    fun getAllCards(): List<CardDto>

    fun getCardByTag(tag: String): List<CardDto>

    fun exist(card: CardDto): Boolean

    fun getCard(cardId: String): CardDto
}