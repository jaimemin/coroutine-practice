package chapter10

import chapter9.getElapsedTime
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    repeat(10) { repeatTime ->
        launch {
            Thread.sleep(1000L)

            println("[${getElapsedTime(startTime)}] 코루틴${repeatTime} 실행 완료") // 자식 시간과 함께 "코루틴 실행 완료" 출력
        }
    }
}