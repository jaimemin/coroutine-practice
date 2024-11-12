package chapter5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] runBlocking 블록 실행")

    async(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] withContext 블록 실행")
    }.await()
}