package chapter9

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delay(1000L)
    println("Hello World")
    delay(1000L)
    println("Hello World")
}