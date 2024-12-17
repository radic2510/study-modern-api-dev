package com.yobi.study.api_dev.aop

import org.springframework.stereotype.Service

@Service
class TimeMonitorTestService {

    @TimeMonitor
    fun testMethod(input: IntArray): Int {
        Thread.sleep(100)
        return input.sum()
    }
}