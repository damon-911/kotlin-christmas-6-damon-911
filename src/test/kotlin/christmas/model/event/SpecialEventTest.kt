package christmas.model.event

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SpecialEventTest {

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `특별 할인 테스트`(specialEvent: SpecialEvent, expected: Int) {
        assertEquals(expected, specialEvent.getBenefit())
    }

    companion object {
        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(SpecialEvent(3), -1_000),
            Arguments.of(SpecialEvent(25), -1_000),
            Arguments.of(SpecialEvent(30), 0)
        )
    }
}