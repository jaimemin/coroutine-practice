package chapter11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>(Dispatchers.IO) {
    launch(Dispatchers.Unconfined) {
        println("일시 중단 전 실행 쓰레드: ${Thread.currentThread().name}")
        delay(100L)
        println("일시 중단 후 실행 쓰레드: ${Thread.currentThread().name}")
    }
}