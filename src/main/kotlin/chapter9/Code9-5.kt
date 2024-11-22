package chapter9

import chapter1.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    delayAndPrint(keyword = "Hello")
    delayAndPrint(keyword = "World")
    println(getElapsedTime(startTime))
}

suspend fun delayAndPrint(keyword: String) {
    delay(1000L)

    println(keyword)
}