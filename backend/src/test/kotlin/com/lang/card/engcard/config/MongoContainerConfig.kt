package com.lang.card.engcard.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.GenericContainer
import javax.annotation.PreDestroy

@TestConfiguration
class MongoContainerConfig {

    lateinit var mongoContainer: GenericContainer<Nothing>

    constructor() {
        val mongoContainer: GenericContainer<Nothing> = FixedHostPortGenericContainer<Nothing>("mongo")
                .withFixedExposedPort(27018,27017)
        mongoContainer.start()
    }

    @PreDestroy
    fun close() {
        mongoContainer.stop()
    }
}