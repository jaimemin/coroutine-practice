package chapter9

import chapter1.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    launch {
        delay(1000L)
        println("Hello")
    }

    launch {
        delay(1000L)
        println("World")
    }

    println(getElapsedTime(startTime))
}