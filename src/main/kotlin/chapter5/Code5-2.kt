package chapter5

import chapter4.printJobState
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
        delay(1000L)

        return@async "Dummy Response"
    }

    networkDeferred.join() // networkDeferred가 실행 완료될 때까지 대기
    printJobState(networkDeferred)
}