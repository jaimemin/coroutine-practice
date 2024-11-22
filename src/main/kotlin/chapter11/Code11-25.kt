package chapter11

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.concurrent.thread
import kotlin.coroutines.resume

fun main() = runBlocking<Unit> {
    val result = suspendCancellableCoroutine<String> { continuation: CancellableContinuation<String> ->
        thread {
            Thread.sleep(1000L)

            continuation.resume("실행 결과")
        }
    }

    println(result)
}