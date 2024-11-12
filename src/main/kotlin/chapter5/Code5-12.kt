package chapter5

import chapter1.getElapsedTime
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val helloString = async(Dispatchers.IO) {
        delay(1000L)

        return@async "Hello"
    }

    val worldString = async(Dispatchers.IO) {
        delay(1000L)

        return@async "World"
    }

    val results = awaitAll(helloString, worldString)

    println("[${getElapsedTime(startTime)}] ${results[0]} ${results[1]}")
}