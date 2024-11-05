package chapter4

import chapter1.getElapsedTime
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${getElapsedTime(startTime)}] 지연 실행")
    }

    delay(1000L)
    lazyJob.start()
}