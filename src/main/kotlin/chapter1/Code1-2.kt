package chapter1

fun main() {
    println("메인 쓰레드 시작")

    throw Exception("Dummy Exception")

    println("메인 쓰레드 종료")
}