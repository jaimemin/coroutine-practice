package chapter7

import chapter1.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    runBlocking {
        delay(1000L)

        println("[${Thread.currentThread().name}] 하위 코루틴 종료")
    }

    println(getElapsedTime(startTime))
}