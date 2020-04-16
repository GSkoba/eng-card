package com.lang.card.engcard.utils

import com.lang.card.engcard.dto.CardDto
import org.junit.jupiter.api.Assertions
import java.util.function.Consumer

class AssertUtils {

    fun assertWithoutId(expected: List<CardDto>, actual: List<CardDto>) {
        val expIterator = expected.sortedBy { it.textOrg }.iterator()
        actual.sortedBy { it.textOrg }.forEach(Consumer {
            Assertions.assertNotNull(it.id)
            val expCardDto = expIterator.next()
            Assertions.assertEquals(it.textOrg, expCardDto.textOrg) { "receivedCard.textOrg must not be a change" }
            Assertions.assertEquals(
                it.textTransl,
                expCardDto.textTransl
            ) { "receivedCard.textTransl must not be a change" }
        })
    }
}