package chapter9

import chapter1.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    delay(1000L)
    println("Hello World")
    delay(1000L)
    println("Hello World")
    println(getElapsedTime(startTime))
}