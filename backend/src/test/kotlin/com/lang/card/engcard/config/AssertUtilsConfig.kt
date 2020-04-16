package com.lang.card.engcard.config

import com.lang.card.engcard.utils.AssertUtils
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class AssertUtilsConfig() {

    @Bean
    fun assertUtils() = AssertUtils()
}