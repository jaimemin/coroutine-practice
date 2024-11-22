package chapter11

import kotlinx.coroutines.*

var cnt = 0
val countChangeDispatcher = newSingleThreadContext("CountChangeThread")

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                increaseCount()
            }
        }
    }

    println("count = ${cnt}")
}

suspend fun increaseCount() = coroutineScope {
    withContext(countChangeDispatcher) {
        cnt += 1
    }
}