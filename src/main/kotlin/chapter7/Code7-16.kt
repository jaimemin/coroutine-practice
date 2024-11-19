package chapter7

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
    launch {
        async {
            println(coroutineContext[CoroutineName])
            println(coroutineContext[CoroutineDispatcher])
        }
    }
}