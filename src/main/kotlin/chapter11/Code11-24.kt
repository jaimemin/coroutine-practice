package chapter11

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

fun main() = runBlocking<Unit> {
    println("runBlocking 코루틴 일시 중단 호출")

    suspendCancellableCoroutine<Unit> { continuation: CancellableContinuation<Unit> ->
        println("일시 중단 시점의 runBlocking 코루틴 실행 정보: ${continuation.context}")

        continuation.resume(Unit)
    }

    println("runBlocking 코루틴 재개 후 실행되는 코드")
}