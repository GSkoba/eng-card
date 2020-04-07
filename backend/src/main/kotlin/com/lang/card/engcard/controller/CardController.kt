package com.lang.card.engcard.controller

import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.service.CardService
import org.springframework.web.bind.annotation.*

@RestController
class CardController(private val cardService: CardService) {

    @PostMapping("/addCard")
    @ResponseBody
    fun addCard(@RequestBody card: CardDto) = cardService.addCard(card)

    @GetMapping("/random")
    @ResponseBody
    fun randomCard() = cardService.getRandomCards()

    @GetMapping("/tag")
    @ResponseBody
    fun getCardsByTag(@RequestParam tag: String) = cardService.getCardByTag(tag)

    @PostMapping("/updateCard")
    fun updateCard(@RequestBody card: CardDto) = cardService.updateCard(card)
}