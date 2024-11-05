package chapter4

import chapter1.getElapsedTime
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val immediateJob: Job = launch {
        println("[${getElapsedTime(startTime)}] 즉시 실행")
    }
}