package chapter7

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        val newJob = Job()

        launch(CoroutineName("Coroutine2") + newJob) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    delay(1000L)
}