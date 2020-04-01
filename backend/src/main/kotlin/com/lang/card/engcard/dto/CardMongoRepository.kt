package com.lang.card.engcard.dto

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CardMongoRepository : MongoRepository<CardDto, String> {
}