package chapter9

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun delayAndPrintHelloWorld() {
    delay(1000L)

    println("Hello World")
}

fun main() = runBlocking<Unit> {
    delayAndPrintHelloWorld()
    delayAndPrintHelloWorld()
}