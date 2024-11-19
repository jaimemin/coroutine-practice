package chapter7

import kotlinx.coroutines.*

// -Dkotlinx.coroutines.debug
@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
    this.launch {
        this.async {
            println(this.coroutineContext[CoroutineName])
            println(this.coroutineContext[CoroutineDispatcher])
        }
    }
}