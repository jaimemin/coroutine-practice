package chapter9

import chapter1.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    delay(1000L)
    println("Hello")
    delay(1000L)
    println("World")
    println(getElapsedTime(startTime))
}