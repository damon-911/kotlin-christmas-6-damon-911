package christmas.model.event

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WeekdayEventTest {

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `평일 할인 테스트`(weekdayEvent: WeekdayEvent, expected: Int) {
        assertEquals(expected, weekdayEvent.getBenefit())
    }

    companion object {
        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(
                WeekdayEvent(4, listOf(Pair("시저샐러드", 1), Pair("바비큐립", 2), Pair("초코케이크", 3))),
                -6_069
            ),
            Arguments.of(
                WeekdayEvent(12, listOf(Pair("타파스", 3), Pair("해산물파스타", 1), Pair("아이스크림", 2))),
                -4_046
            )
        )
    }
}