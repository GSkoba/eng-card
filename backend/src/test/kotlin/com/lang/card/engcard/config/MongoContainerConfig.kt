package com.lang.card.engcard.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.FixedHostPortGenericContainer
import org.testcontainers.containers.GenericContainer
import java.util.*

@TestConfiguration
class MongoContainerConfig() {

    @Bean(destroyMethod = "stop")
    fun mongoContainer(): GenericContainer<Nothing> {
        val mongoContainer: GenericContainer<Nothing> = FixedHostPortGenericContainer<Nothing>("mongo")
                .withFixedExposedPort(27018,27017)
        mongoContainer.start()
        return mongoContainer
    }
}