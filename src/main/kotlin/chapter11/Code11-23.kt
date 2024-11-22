package chapter11

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine

fun main() = runBlocking<Unit> {
    println("runBlocking 코루틴 일시 중단 호출")

    suspendCancellableCoroutine<Unit> { continuation: CancellableContinuation<Unit> ->
        println("일시 중단 시점의 runBlocking 코루틴 실행 정보: ${continuation.context}")
    }

    println("일시 중단된 코루틴이 재개되지 않아 실행되지 않는 코드")
}