package chapter8

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit>(CoroutineName("Parent Coroutine")) {
    launch(CoroutineName("Child Coroutine")) {
        val result = withTimeoutOrNull(1000L) {
            delay(2000L)

            return@withTimeoutOrNull "결과"
        }

        println(result)
    }
}