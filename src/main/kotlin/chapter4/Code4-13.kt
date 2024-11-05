package chapter4

import kotlinx.coroutines.*

/**
 * 코루틴 블록 내부에 코루틴의 취소를 확인할 수 있는 시점이 없기 때문에 무한 루프
 */
fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
        }
    }

    delay(100L)
    whileJob.cancel()
}
