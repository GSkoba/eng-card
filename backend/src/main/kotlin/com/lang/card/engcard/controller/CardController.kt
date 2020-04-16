package com.lang.card.engcard.controller

import com.lang.card.engcard.dto.CardDto
import com.lang.card.engcard.service.CardService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cards")
@Api(value = "/cards", description = "Contains actions over cards")
class CardController(private val cardService: CardService) {

    @PostMapping("/add")
    @ApiOperation("add new card, required param textOrg and textTrans")
    @ResponseBody
    fun addCard(@RequestBody card: CardDto) = ResponseEntity.ok().body(cardService.addCard(card))

    @GetMapping("/rand")
    @ApiOperation("get cards in random order")
    @ResponseBody
    fun randomCard() = ResponseEntity.ok().body(cardService.getRandomCards())

    @GetMapping("/tag")
    @ApiOperation("get cards by tag")
    @ResponseBody
    fun getCardsByTag(@RequestParam tag: String) = ResponseEntity.ok().body(cardService.getCardByTag(tag))

    @PostMapping("/update")
    @ApiOperation("update exist card data")
    @ResponseBody
    fun updateCard(@RequestBody card: CardDto) = ResponseEntity.ok().body(cardService.updateCard(card))

    @GetMapping("/all")
    @ApiOperation("get all card from db")
    @ResponseBody
    fun all() = ResponseEntity.ok().body(cardService.getAllCards())

    @GetMapping("/{cardId}")
    @ApiOperation("get card by id")
    @ResponseBody
    fun getCard(@PathVariable("cardId") cardId: String) = ResponseEntity.ok().body(cardService.getCard(cardId))
}