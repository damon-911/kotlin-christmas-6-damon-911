package christmas.model.event

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WeekendEventTest {

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `주말 할인 테스트`(weekendEvent: WeekendEvent, expected: Int) {
        assertEquals(expected, weekendEvent.getBenefit())
    }

    companion object {
        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(
                WeekendEvent(8, listOf(Pair("시저샐러드", 1), Pair("바비큐립", 2), Pair("초코케이크", 3))),
                -4_046
            ),
            Arguments.of(
                WeekendEvent(23, listOf(Pair("타파스", 3), Pair("해산물파스타", 1), Pair("아이스크림", 2))),
                -2_023
            )
        )
    }
}