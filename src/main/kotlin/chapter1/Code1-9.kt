package chapter1

fun main() {
    val startTime = System.currentTimeMillis()

    println("[${getElapsedTime(startTime)}] 메인 쓰레드 시작")
    Thread.sleep(1000)
    println("[${getElapsedTime(startTime)}] 쓰레드 블로킹이 끝나고 실행되는 작업")
}