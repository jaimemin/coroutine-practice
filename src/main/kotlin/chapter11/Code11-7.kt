package chapter11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger

var count2 = AtomicInteger(0)

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                count2.getAndUpdate {
                    it + 1
                }
            }
        }
    }

    println("count = ${count2}")
}