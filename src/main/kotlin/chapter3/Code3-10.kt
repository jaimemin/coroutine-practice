package chapter3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(Dispatchers.IO.limitedParallelism(100)) {
        repeat(200) {
            launch {
                Thread.sleep(1000)
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }
        }
    }
}