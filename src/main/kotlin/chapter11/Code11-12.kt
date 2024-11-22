package chapter11

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch {
        println("작업1")
    }

    println("작업2")
}