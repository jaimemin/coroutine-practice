package chapter3

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val dispatcher = newSingleThreadContext("Single thread")

    launch(dispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
}