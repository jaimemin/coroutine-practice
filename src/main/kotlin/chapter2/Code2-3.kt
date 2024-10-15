package chapter2

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] 실행")

    launch {
        println("[${Thread.currentThread().name}] 실행")
    }
    launch {
        println("[${Thread.currentThread().name}] 실행")
    }
}