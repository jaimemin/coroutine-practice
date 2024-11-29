package chapter12

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatAddUseCaseTest {

    @Test
    fun `100번 더하면 100이 반환된다`() = runBlocking<Unit> {
        // given
        val repeatAddUseCase = RepeatAddUseCase()

        // when
        val result = repeatAddUseCase.add(100)

        // then
        assertEquals(100, result)
    }
}