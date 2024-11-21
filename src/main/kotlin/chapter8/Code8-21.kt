package chapter8

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit>(CoroutineName("Parent Coroutine")) {
    launch(CoroutineName("Child Coroutine")) {
        withTimeout(1000L) {
            delay(2000L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    delay(2000L)

    println("[${Thread.currentThread().name}] 코루틴 실행")
}