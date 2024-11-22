package chapter11

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(start = CoroutineStart.UNDISPATCHED) {
        println("일시 중단 전에는 CoroutineDispatcher를 거치지 않고 즉시 실행된다")
        delay(100L)
        println("일시 중단 후에는 CoroutineDispatcher를 거쳐 실행된다")
    }
}