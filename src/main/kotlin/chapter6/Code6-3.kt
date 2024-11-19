package chapter6

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

val sampleJob = Job()
val coroutineContext1: CoroutineContext =
    CoroutineName("MyCoroutine1") + newSingleThreadContext("MyThread1") + sampleJob
val coroutineContext2: CoroutineContext = CoroutineName("MyCoroutine2") + newSingleThreadContext("MyThread2")
val combinedCoroutineContext = coroutineContext1 + coroutineContext2

fun main() = runBlocking<Unit> {
    launch(context = combinedCoroutineContext) {
        println("[${Thread.currentThread().name}] 실행")
        println(combinedCoroutineContext[Job])
    }
    delay(100) // 실행 시간을 확보
}