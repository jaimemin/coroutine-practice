package chapter5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] runBlocking 블록 실행")

    withContext(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] withContext 블록 실행")
    }
}