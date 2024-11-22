package chapter11

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(start = CoroutineStart.UNDISPATCHED) {
        println("작업1")
    }

    println("작업2")
}