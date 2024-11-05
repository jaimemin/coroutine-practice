package chapter4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job: Job = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
    }

    printJobState(job)
}

fun printJobState(job: Job) {
    println(
        "Job State\n" +
                "isActive >> ${job.isActive}\n" +
                "isCompleted >> ${job.isCompleted}\n" +
                "isCancelled >> ${job.isCancelled}"
    )
}
