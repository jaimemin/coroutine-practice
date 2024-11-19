package chapter7

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CustomCoroutineScope : CoroutineScope {
    override val coroutineContext: CoroutineContext = Job() + newSingleThreadContext("CustomScopeThread")
}

// -Dkotlinx.coroutines.debug
fun main() = runBlocking<Unit> {
    val coroutineScope = CustomCoroutineScope()
    coroutineScope.launch {
        delay(100L)

        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }

    Thread.sleep(1000L)
}