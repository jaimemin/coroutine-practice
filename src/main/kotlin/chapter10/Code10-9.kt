package chapter10

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val dispatcher = newFixedThreadPoolContext(2, "MyThread")

    launch(dispatcher) {
        repeat(5) {
            println("[${Thread.currentThread().name}] 코루틴 실행이 일시 중단 됩니다")
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행이 재개 됩니다")
        }
    }
}