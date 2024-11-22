package chapter11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>(Dispatchers.IO) {
    delay(1000L)
    println("runBlocking 코루틴 실행 쓰레드: ${Thread.currentThread().name}")

    launch {
        println("launch 코루틴 실행 쓰레드: ${Thread.currentThread().name}")
    }
}