package chapter5

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private val myDispatcher1 = newSingleThreadContext("MyThread1")
private val myDispatcher2 = newSingleThreadContext("MyThread2")

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread()}] 코루틴 실행")

    withContext(myDispatcher1) {
        println("[${Thread.currentThread()}] 코루틴 실행")
        withContext(myDispatcher2) {
            println("[${Thread.currentThread()}] 코루틴 실행")
        }

        println("[${Thread.currentThread()}] 코루틴 실행")
    }

    println("[${Thread.currentThread()}] 코루틴 실행")
}