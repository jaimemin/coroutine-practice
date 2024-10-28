package chapter3

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val multiThreadDispatcher = newFixedThreadPoolContext(2, "MultiThread")

    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }

    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
}