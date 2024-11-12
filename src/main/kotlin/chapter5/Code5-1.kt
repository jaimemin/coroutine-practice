package chapter5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
        delay(1000L)

        return@async "Dummy Response"
    }

    val result = networkDeferred.await()
    println(result)
}