package chapter6

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
    val coroutineName = CoroutineName("MyCoroutine")
    val dispatcher = Dispatchers.IO
    val job = Job()
    val coroutineContext: CoroutineContext = coroutineName + dispatcher + job
    val deletedCoroutineContext = coroutineContext.minusKey(CoroutineName)

    println(coroutineContext[CoroutineName])
    println(coroutineContext[CoroutineDispatcher])
    println(coroutineContext[Job])
}