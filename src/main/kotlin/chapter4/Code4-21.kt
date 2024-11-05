package chapter4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(5000L)
    }

    job.cancelAndJoin() // 코루틴 취소 요청 + 취소가 완료될 때까지 대기
    printJobState(job)
}