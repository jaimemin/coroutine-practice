package chapter4

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(1000L)
    }

    delay(2000L)
    printJobState(job)
}