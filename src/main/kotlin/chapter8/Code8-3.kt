package chapter8

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val parentJob = launch(CoroutineName("Parent Coroutine")) {
        launch(CoroutineName("Coroutine1") + Job()) { // 새로운 Job 객체를 만들어 Coroutine1에 연결
            launch(CoroutineName("Coroutine3")) {
                delay(100L)

                println("[${Thread.currentThread().name}] 코루틴 실행")
            }

            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }

        launch(CoroutineName("Coroutine2")) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    delay(20L) // 코루틴들이 모두 생성될 때까지 대기
    parentJob.cancel()
    delay(1000L)
}