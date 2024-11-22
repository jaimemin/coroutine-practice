package chapter9

import chapter1.getElapsedTime
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    delayAndPrintHelloWorld()
    delayAndPrintHelloWorld()
    println(getElapsedTime(startTime))
}