package chapter8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        try {
            launch(CoroutineName("Coroutine1")) {
                throw Exception("Coroutine1에 예외가 발생했습니다")
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)

        println("Coroutine2 실행 완료")
    }
}