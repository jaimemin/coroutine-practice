package chapter11

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch {
        println("작업1")
    }

    job.cancel()
    println("작업2")
}