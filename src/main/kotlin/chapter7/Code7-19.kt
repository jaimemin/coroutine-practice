package chapter7

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행 완료")
        }

        CoroutineScope(Dispatchers.IO).launch(CoroutineName("Coroutine4")) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행 완료")
        }

        this.cancel()
    }

    launch(CoroutineName("Coroutine2")) {
        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
}