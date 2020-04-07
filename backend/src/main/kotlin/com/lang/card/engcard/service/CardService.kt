package com.lang.card.engcard.service

import com.lang.card.engcard.dao.ICardDao
import com.lang.card.engcard.dto.CardDto
import org.springframework.stereotype.Service

@Service
class CardService(val cardDao: ICardDao) {

    fun addCard(card: CardDto) = cardDao.addCard(card)

    fun addCard(card: List<CardDto>) = cardDao.addCard(card)

    fun updateCard(card: CardDto) = cardDao.updateCard(card)

    fun getRandomCards() = cardDao.getRandomCards()

    fun getAllCards() = cardDao.getAllCards()

    fun getCardByTag(tag: String) = cardDao.getCardByTag(tag)
}