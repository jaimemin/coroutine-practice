package chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("CoroutineA")
    launch(coroutineContext) {
        println("[${Thread.currentThread().name}] 부모 코루틴 실행")

        launch {
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
    }
}