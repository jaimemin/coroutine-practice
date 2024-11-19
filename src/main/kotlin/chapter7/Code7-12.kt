package chapter7

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    coroutineScope.launch {
        delay(100L)

        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }

    Thread.sleep(1000L)
}