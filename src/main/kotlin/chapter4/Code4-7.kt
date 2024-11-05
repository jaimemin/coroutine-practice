package chapter4

import chapter1.getElapsedTime
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 실행해도 아무 로그 안 나옴
 * 지연 코루틴을 실행하기 위해서는 Job 객체의 start 함수를 명시적으로 호출해야 함
 */
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${getElapsedTime(startTime)}] 지연 실행")
    }
}