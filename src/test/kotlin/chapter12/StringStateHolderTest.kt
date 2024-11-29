package chapter12

import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StringStateHolderTest {

    @Test
    fun `updateStringWithDelay("ABC")가 호출되면 문자열이 ABC로 변경된다`() {
        // given
        val testDispatcher = StandardTestDispatcher()
        val stringStateHolder = StringStateHolder(dispatcher = testDispatcher)

        // when
        stringStateHolder.updateStringWithDelay("ABC")

        // then
        testDispatcher.scheduler.advanceUntilIdle()
        Assertions.assertEquals("ABC", stringStateHolder.stringState)
    }
}