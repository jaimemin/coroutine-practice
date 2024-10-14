package chapter1

class ExampleThread : Thread() {

    override fun run() {
        println("[$(Thread.currentThread().name}] 새로운 쓰레드 시작")
        Thread.sleep(2000)
        println("[$(Thread.currentThread().name}] 새로운 쓰레드 종료")
    }
}

fun main() {
    println("[$(Thread.currentThread().name}] 메인 쓰레드 시작")
    ExampleThread().start()
    Thread.sleep(1000)
    println("[$(Thread.currentThread().name}] 메인 쓰레드 종료")
}