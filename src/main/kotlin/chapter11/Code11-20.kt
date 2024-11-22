package chapter11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>(Dispatchers.IO) {
    println("작업1")

    launch(Dispatchers.Unconfined) {
        println("작업2")
    }

    println("작업3")
}