package chapter7

import kotlinx.coroutines.runBlocking

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> { // 루트 Job 생성
    println("[${Thread.currentThread().name}] 코루틴 실행")
}