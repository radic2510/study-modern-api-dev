package com.yobi.study.api_dev

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@SpringBootApplication
class ApiDevApplication

fun main(args: Array<String>) {
	runApplication<ApiDevApplication>(*args)
}
