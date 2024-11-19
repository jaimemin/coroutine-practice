package chapter7

import chapter1.getElapsedTime
import chapter4.printJobState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val parentJob = launch {
        launch {
            delay(1000L)

            println("[${getElapsedTime(startTime)}] 자식 코루틴 실행 완료")
        }

        println("[${getElapsedTime(startTime)}] 부모 코루틴이 실행하는 마지막 코드")
    }

    parentJob.invokeOnCompletion { // 부모 코루틴이 종료될 시 호출되는 콜백 등록
        println("[${getElapsedTime(startTime)}] 부모 코루틴 실행 완료")
    }

    delay(500L)
    printJobState(parentJob)
}