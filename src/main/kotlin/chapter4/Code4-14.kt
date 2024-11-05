package chapter4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
            delay(1)
        }
    }

    delay(100L)
    whileJob.cancel()
}
