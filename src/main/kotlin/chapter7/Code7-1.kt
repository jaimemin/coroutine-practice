package chapter7

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch { // 부모 코루틴
        launch {  // 자식 코루틴
            println("자식 코루틴 실행")
        }
    }
}