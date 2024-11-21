package chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("ParentCoroutine")

    launch(coroutineContext) {
        println("[${Thread.currentThread().name}] 부모 코루틴 실행")

        launch(CoroutineName("ChildCoroutine")) {
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
    }
}