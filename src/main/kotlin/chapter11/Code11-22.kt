package chapter11

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    println("runBlocking 코루틴 실행 쓰레드: ${Thread.currentThread().name}")

    launch(start = CoroutineStart.UNDISPATCHED) {
        println("[CoroutineStart.UNDISPATCHED] 코루틴이 시작 시 사용하는 쓰레드: ${Thread.currentThread().name}")
        delay(100L)
        println("[CoroutineStart.UNDISPATCHED] 코루틴이 재개 시 사용하는 쓰레드: ${Thread.currentThread().name}")
    }.join()

    launch(context = Dispatchers.Unconfined) {
        println("[Dispatchers.Unconfined] 코루틴이 시작 시 사용하는 쓰레드: ${Thread.currentThread().name}")
        delay(100L)
        println("[Dispatchers.Unconfined] 코루틴이 재개 시 사용하는 쓰레드: ${Thread.currentThread().name}")
    }.join()
}