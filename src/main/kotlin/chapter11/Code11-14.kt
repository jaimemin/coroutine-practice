package chapter11

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch(start = CoroutineStart.ATOMIC) {
        println("작업1")
    }

    job.cancel()
    println("작업2")
}