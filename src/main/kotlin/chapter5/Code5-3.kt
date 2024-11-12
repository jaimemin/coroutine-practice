package chapter5

import chapter1.getElapsedTime
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)

        return@async arrayOf("James", "Jason")
    }

    val participants1 = participantDeferred1.await()

    val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)

        return@async arrayOf("Jenny")
    }

    val participants2 = participantDeferred2.await()

    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*participants1, *participants2)}")
}