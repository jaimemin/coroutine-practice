package chapter7

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val infiniteJob = launch {
        while (true) {
            delay(1000L)
        }
    }

    infiniteJob.invokeOnCompletion {
        println("invokeOnCompletion 콜백 실행됨")
    }

    infiniteJob.cancel()
}