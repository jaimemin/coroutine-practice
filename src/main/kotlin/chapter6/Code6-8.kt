package chapter6

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineName: CoroutineName = CoroutineName("MyCoroutine")
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    val coroutineContext = coroutineName + dispatcher

    println(coroutineContext[coroutineName.key])
    println(coroutineContext[dispatcher.key])
}