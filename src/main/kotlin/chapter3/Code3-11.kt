package chapter3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatchers.Main은 일반적으로 UI가 있는 애플리케이션에서 메인 쓰레드의 사용을 위해 사용되는 특별한 CoroutineDispatcher 객체
 * 따라서 Dispatchers.Main에 접근하면 IllegalStateException과 함께 메인 디스페처를 제공하는 모듈이 없다는 오류가 발생
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Main) {
        println("[${Thread.currentThread().name}] Coroutine 실행")
    }
}