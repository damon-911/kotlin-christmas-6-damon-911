package christmas.model.event

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ChristmasEventTest {

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `크리스마스 디데이 할인 테스트`(christmasEvent: ChristmasEvent, expected: Int) {
        assertEquals(expected, christmasEvent.getBenefit())
    }

    companion object {
        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(ChristmasEvent(4), -1_300),
            Arguments.of(ChristmasEvent(25), -3_400),
            Arguments.of(ChristmasEvent(28), 0)
        )
    }
}