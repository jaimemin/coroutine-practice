package chapter4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job = launch(Dispatchers.Default) { // 취소를 확인할 수 있는 시점
        while (true) {
            // 작업 실행
        }
    }

    job.cancel();
    printJobState(job)
}