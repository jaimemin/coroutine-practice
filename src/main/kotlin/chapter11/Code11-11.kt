package chapter11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger

var count4 = AtomicInteger(0)

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            val currentCount = count4.incrementAndGet()
        }
    }

    println("count = ${count4}")
}