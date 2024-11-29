package chapter12

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestCoroutineSchedulerTest {

    @Test
    fun `가상 시간 조절 테스트`() {
        // 테스트 환경 설정
        val testCoroutineScheduler = TestCoroutineScheduler()

        testCoroutineScheduler.advanceTimeBy(5000L) // 가상 시간에서 5초를 흐르게 만듬
        assertEquals(5000L, testCoroutineScheduler.currentTime) // 현재 시간이 5초

        testCoroutineScheduler.advanceTimeBy(6000L) // 가상 시간에서 6초를 흐르게 만듬
        assertEquals(11000L, testCoroutineScheduler.currentTime) // 현재 시간이 11초

        testCoroutineScheduler.advanceTimeBy(10000L) // 가상 시간에서 10초를 흐르게 만듬
        assertEquals(21000L, testCoroutineScheduler.currentTime) // 현재 시간이 21초
    }

    @Test
    fun `가상 시간 위에서 테스트 진행`() {
        // 테스트 환경 설정
        val testCoroutineScheduler: TestCoroutineScheduler = TestCoroutineScheduler()
        val testDispatcher: TestDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
        val testCoroutineScope: CoroutineScope = CoroutineScope(testDispatcher)

        // given
        var result = 0

        // when
        testCoroutineScope.launch {
            delay(10000L)
            result = 1
            delay(1000L)
            result = 2

            println(Thread.currentThread().name)
        }

        // then
        assertEquals(0, result)
        testCoroutineScheduler.advanceTimeBy(5000L)
        assertEquals(0, result)
        testCoroutineScheduler.advanceTimeBy(6000L)
        assertEquals(1, result)
        testCoroutineScheduler.advanceTimeBy(10000L)
        assertEquals(2, result)
    }

    @Test
    fun `advanceUntilIdle의 동작 살펴보기`() {
        // 테스트 환경 설정
        val testCoroutineScheduler: TestCoroutineScheduler = TestCoroutineScheduler()
        val testDispatcher: TestDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
        val testCoroutineScope = CoroutineScope(context = testDispatcher)

        // given
        var result = 0

        // when
        testCoroutineScope.launch {
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }

        testCoroutineScheduler.advanceUntilIdle() // testCoroutineScope 내부의 코루틴이 모두 실행되게 만듬

        // then
        assertEquals(2, result)
    }

    @Test
    fun `StandardTestDispatcher 사용하기`() {
        // 테스트 환경 설정
        val testDispatcher: TestDispatcher = StandardTestDispatcher()
        val testCoroutineScope = CoroutineScope(testDispatcher)

        // given
        var result = 0

        // when
        testCoroutineScope.launch {
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }

        testDispatcher.scheduler.advanceUntilIdle() // testCoroutineScope 내부의 코루틴이 모두 실행되게 만듬

        assertEquals(2, result)
    }

    @Test
    fun `TestScope 사용하기`() {
        // 테스트 환경 설정
        val testCoroutineScope: TestScope = TestScope()

        // given
        var result = 0

        // when
        testCoroutineScope.launch {
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }

        testCoroutineScope.advanceUntilIdle() // testCoroutineScope 내부의 코루틴이 모두 실행되게 만듬

        assertEquals(2, result)
    }

    @Test
    fun `runTest 사용하기`() {
        // given
        var result = 0

        // when
        runTest { // this: testScope
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }

        // then
        assertEquals(2, result)
    }

    @Test
    fun `runTest로 테스트 감싸기`() = runTest {
        // given
        var result = 0

        // when
        delay(10_000L)
        result = 1
        delay(10_000L)
        result = 2

        // then
        assertEquals(2, result)
    }

    @Test
    fun `runTest에서 가상 시간 확인`() = runTest {
        delay(10_000L)
        println("가상 시간: ${this.currentTime}ms")
        delay(10_000L)
        println("가상 시간: ${this.currentTime}ms")
    }

    @Test
    fun `runTest 내부에서 advanceUntilIdle 사용하기`() = runTest {
        var result = 0

        launch {
            delay(10_000L)
            result = 1
        }

        println("가상 시간: ${this.currentTime}ms, result = ${result}")
        advanceUntilIdle()
        println("가상 시간: ${this.currentTime}ms, result = ${result}")
    }

    @Test
    fun `runTest 내부에서 join 사용하기`() = runTest {
        var result = 0

        launch {
            delay(10_000L)
            result = 1
        }.join()

        println("가상 시간: ${this.currentTime}ms, result = ${result}")
    }
}