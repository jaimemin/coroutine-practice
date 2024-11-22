package chapter10

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
    launch {
        while (true) {
            println("자식 코루틴에서 작업 실행 중")

            yield() // 쓰레드 사용 권한 양보
        }
    }

    while (true) {
        println("부모 코루틴에서 작업 실행 중")

        yield() // 쓰레드 사용 권한 양보
    }
}