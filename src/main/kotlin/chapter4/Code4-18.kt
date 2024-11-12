package chapter4

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job = launch { // 실행 중 상태의 코루틴 생성
        delay(1000L)
    }

    printJobState(job)
}