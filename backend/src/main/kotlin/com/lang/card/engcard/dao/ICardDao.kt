package com.lang.card.engcard.dao

import com.lang.card.engcard.dto.CardDto

interface ICardDao  {

    fun addCard(card: CardDto) : CardDto

    fun updateCard(card: CardDto)

    fun getRandomCards() : List<CardDto>

    fun getCardByTag(tag: String) : List<CardDto>
}