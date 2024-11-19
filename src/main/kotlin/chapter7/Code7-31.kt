package chapter7

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit>(Dispatchers.IO) {
    delay(5000L)

    println("[${Thread.currentThread().name}] 코루틴 종료")
}