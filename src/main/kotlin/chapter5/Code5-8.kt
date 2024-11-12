package chapter5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
    val result: String = withContext(Dispatchers.IO) {
        delay(1000L)

        return@withContext "Dummy Response"
    }

    println(result)
}