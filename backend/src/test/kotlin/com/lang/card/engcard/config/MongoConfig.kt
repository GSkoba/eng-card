package com.lang.card.engcard.config

import com.mongodb.MongoClient
import de.flapdoodle.embed.mongo.MongodExecutable
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder
import de.flapdoodle.embed.mongo.config.Net
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.process.runtime.Network
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import java.io.IOException

@TestConfiguration
class MongoConfig {

    val bindIp = "localhost"
    val port = 12345

    @Bean(destroyMethod = "stop")
    @Throws(IOException::class)
    fun mongodExecutable(): MongodExecutable {
        val starter = MongodStarter.getDefaultInstance()
        val mongodConfig = MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(Net(bindIp, port, Network.localhostIsIPv6()))
                .build()
        val mongo = starter.prepare(mongodConfig)
        mongo.start()
        return mongo;
    }

    @Bean(destroyMethod = "close")
    fun mongoClient() = MongoClient(bindIp, port)
}