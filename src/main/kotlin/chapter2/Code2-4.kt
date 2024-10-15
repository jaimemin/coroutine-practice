package chapter2

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>(context = CoroutineName("Main")) {
    println("[${Thread.currentThread().name}] 실행")

    launch(context = CoroutineName("Coroutine1")) {
        println("[${Thread.currentThread().name}] 실행")
    }
    launch(context = CoroutineName("Coroutine2")) {
        println("[${Thread.currentThread().name}] 실행")
    }
}