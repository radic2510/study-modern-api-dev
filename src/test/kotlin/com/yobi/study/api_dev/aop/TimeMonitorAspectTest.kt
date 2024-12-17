package com.yobi.study.api_dev.aop

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class TimeMonitorAspectTest {

    @Autowired
    lateinit var testService: TimeMonitorTestService

    @Test
    fun `test TimeMonitor annotation logs execution time`() {

        val input = intArrayOf(1, 2, 3, 4, 5)
        val result = testService.testMethod(input)

        assertEquals(15, result)
    }
}