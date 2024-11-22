package chapter10

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job = launch {
        while (this.isActive) {
            println("작업 중")

            yield() // 쓰레드 양보 명시적으로
        }
    }

    delay(100L)
    job.cancel();
}