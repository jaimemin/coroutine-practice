package chapter1

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

fun main() {
    val executorService: ExecutorService = Executors.newFixedThreadPool(2)
    val future: Future<String> = executorService.submit<String> {
        Thread.sleep(2000)

        return@submit "작업 1 완료"
    }

    val result = future.get()
    println(result)
    executorService.shutdown()
}