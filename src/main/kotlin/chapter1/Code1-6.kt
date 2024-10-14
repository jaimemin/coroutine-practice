package chapter1

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    val startTime = System.currentTimeMillis()
    val executorService: ExecutorService = Executors.newFixedThreadPool(2)

    executorService.submit {
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업1 시작")
        Thread.sleep(1000L) // 1초간 대기
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업1 완료")
    }

    executorService.submit {
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업2 시작")
        Thread.sleep(1000L) // 1초간 대기
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업2 완료")
    }

    executorService.shutdown()
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"