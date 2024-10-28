package chapter3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default.limitedParallelism(2)) {
        repeat(10) {
            launch {
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }
        }
    }
}