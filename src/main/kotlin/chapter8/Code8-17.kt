package chapter8

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    async(CoroutineName("Coroutine1")) {
        throw Exception("Coroutine1에 예외가 발생했습니다")
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)

        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
}