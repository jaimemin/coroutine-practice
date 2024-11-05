package chapter4

import chapter1.getElapsedTime
import kotlinx.coroutines.*

/**
 * cancel 함수를 호출하더라도 바로 취소되는 것이 아니라 미래의 어느 시점에 취소되기 때문에
 * longJob 코루틴이 취소된 이후 executeAfterJobCancelled 함수가 실행되는 것을 보장 X
 */
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 반복횟수 ${repeatTime}")
        }
    }

    longJob.cancel()
//    executeAfterJobCancelled() // 코루틴 취소 후 실행되어야 하는 동작
}