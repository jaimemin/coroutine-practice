package chapter6

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineName: CoroutineName = CoroutineName("MyCoroutine")

    if (coroutineName.key === CoroutineName.Key) {
        println("coroutineName.key와 CoroutineName.Key 동일합니다")
    }
}