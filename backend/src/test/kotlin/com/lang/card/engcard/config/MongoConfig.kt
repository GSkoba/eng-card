package com.lang.card.engcard.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.GenericContainer
import java.util.*

@TestConfiguration
class MongoConfig() {

    @Bean(destroyMethod = "stop")
    fun mongoContainer(): GenericContainer<Nothing> {
        val mongoContainer: GenericContainer<Nothing> = GenericContainer<Nothing>("mongo")
                .withExposedPorts(27017)
        mongoContainer.start()
        val mongoProp = Properties()
        mongoProp.setProperty("mongodb.uri",
                "${mongoContainer.containerIpAddress}:${mongoContainer.getMappedPort(27017)}")
        System.setProperties(mongoProp)
        return mongoContainer
    }
}