package chapter1

fun main() {
    println("[$(Thread.currentThread().name}] 메인 쓰레드 시작")
    ExampleThread().apply {
        isDaemon = true
    }.start()
    Thread.sleep(1000)
    println("[$(Thread.currentThread().name}] 메인 쓰레드 종료")
}