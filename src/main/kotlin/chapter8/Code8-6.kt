package chapter8

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val coroutineScope = CoroutineScope(SupervisorJob())

    coroutineScope.apply {
        launch(CoroutineName("Coroutine1")) {
            launch(CoroutineName("Coroutine3")) {
                throw Exception("예외 발생")
            }

            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)

        println("[${Thread.currentThread().name}] 코루틴 실행")
    }

    delay(1000L)
}