package chapter11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger

var count3 = AtomicInteger(0)

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            val currentCount = count3.get()
            // 위 코드와 아래 코드의 실행 사이에 다른 쓰레드가 count의 값을 읽거나 변경 가능
            count3.set(currentCount + 1)
        }
    }

    println("count = ${count3}")
}