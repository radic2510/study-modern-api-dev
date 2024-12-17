package com.yobi.study.api_dev.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class TimeMonitorAspect {

    private val logger = LoggerFactory.getLogger(TimeMonitorAspect::class.java)

    @Around("@annotation(TimeMonitor)")
    @Throws(Throwable::class)
    fun logTime(joinPoint: ProceedingJoinPoint): Any {
        val methodName = joinPoint.signature.name
        val args = joinPoint.args.getOrNull(0) as? IntArray ?: intArrayOf()

        logger.info("Starting ${joinPoint.signature.toShortString()}")
        logger.info("$methodName input -> ${args.contentToString()}")

        val startTime = System.nanoTime() // start
        val result = joinPoint.proceed()
        val executionTime = System.nanoTime() - startTime // end - start

        logger.info("${methodName}ed -> ${args.contentToString()}")
        logger.info("$methodName took: $executionTime ns\n")

        return result
    }
}
