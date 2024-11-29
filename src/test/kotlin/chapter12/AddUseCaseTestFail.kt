package chapter12

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class AddUseCaseTestFail {

    @Test
    fun `1 더하기 2는 4가 아니다`() {
        val addUseCase: AddUseCase = AddUseCase()
        val result = addUseCase.add(1, 2)

        assertNotEquals(4, result) // 1 더하기 2는 3이므로 단언은 실패한다
    }
}