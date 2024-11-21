package chapter8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit>(CoroutineName("Parent Coroutine")) {
    try {
        withTimeout(1000L) {
            delay(2000L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    } catch (e: Exception) {
        println(e)
    }
}