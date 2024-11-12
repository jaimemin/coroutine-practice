package chapter5

import chapter1.getElapsedTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val helloString = withContext(Dispatchers.IO) {
        delay(1000L)

        return@withContext "Hello"
    }

    val worldString = withContext(Dispatchers.IO) {
        delay(1000L)

        return@withContext "World"
    }

    println("[${getElapsedTime(startTime)}] ${helloString} ${worldString}")
}