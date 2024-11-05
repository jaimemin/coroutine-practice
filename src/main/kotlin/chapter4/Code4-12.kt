package chapter4

import chapter1.getElapsedTime
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 반복횟수 ${repeatTime}")
        }
    }

    longJob.cancelAndJoin() // longJob이 취소될 때까지 runBlocking 코루틴 일시 중단
    executeAfterJobCancelled() // 코루틴 취소 후 실행되어야 하는 동작
}

fun executeAfterJobCancelled() {
    println("동작")
}
