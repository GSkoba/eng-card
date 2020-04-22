package com.lang.card.engcard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class EngCardApplication

fun main(args: Array<String>) {
	runApplication<EngCardApplication>(*args)
}
