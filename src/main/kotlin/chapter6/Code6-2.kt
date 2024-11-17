package chapter6

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val coroutineContext: CoroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    val newCoroutineContext: CoroutineContext = coroutineContext + CoroutineName("NewCoroutine")

    launch(context = newCoroutineContext) {
        println("[${Thread.currentThread().name}] 실행")
    }
}