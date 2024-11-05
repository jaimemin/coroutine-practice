package chapter4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job = launch(Dispatchers.IO) {
        println("[%${Thread.currentThread().name}] 실행")
    }
}