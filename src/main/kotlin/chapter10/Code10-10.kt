package chapter10

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val dispatcher = newFixedThreadPoolContext(2, "MyThread")

    launch(dispatcher) {
        repeat(5) {
            println("[${Thread.currentThread().name}] 쓰레드를 점유한 상태로 100 밀리초간 대기합니다")
            Thread.sleep(100L)
            println("[${Thread.currentThread().name}] 점유한 쓰레드에서 마저 실행됩니다.")
        }
    }
}