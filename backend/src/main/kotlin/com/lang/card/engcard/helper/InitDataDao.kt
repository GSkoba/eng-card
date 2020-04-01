package com.lang.card.engcard.helper

import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.service.CardService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty(prefix = "eng-card.data.init-dao", name = ["enabled"], havingValue = "true",
        matchIfMissing = false)
class InitDataDao(val cardService: CardService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val initData = mapOf("dog" to "собака", "car" to "машина", "house" to "дом",
        "environment" to "окружающая среда")
        initData.forEach { (key, value) -> cardService.addCard(CardDto(key, value))}
    }
}