package chapter7

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        val parentContext = this.coroutineContext // Save the parent context
        val newJob = Job(parent = parentContext[Job])
        println("[${Thread.currentThread().name}] 코루틴 실행")

        launch(CoroutineName("Coroutine2") + newJob) {
            delay(100L)
            val currentJob = this.coroutineContext[Job]

            println("[${Thread.currentThread().name}] 코루틴 실행")
            println("currentJob?.parent === newJob >>> ${currentJob?.parent === newJob}")
        }
    }

    delay(1000L)
}