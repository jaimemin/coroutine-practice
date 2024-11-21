package chapter8

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val job = launch {
        delay(1000L)
    }

    job.invokeOnCompletion { exception ->
        println(exception)
    }

    job.cancel()
}