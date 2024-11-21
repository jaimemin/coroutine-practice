package chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> { // 루트 Job 생성
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }

        launch(CoroutineName("Coroutine4")) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    launch(CoroutineName("Coroutine2")) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    delay(100L)
}