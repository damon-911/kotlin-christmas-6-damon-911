package christmas.model.event

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class GiftEventTest {

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `증정 이벤트 테스트`(giftEvent: GiftEvent, expected: Int) {
        Assertions.assertEquals(expected, giftEvent.getBenefit())
    }

    companion object {
        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(GiftEvent(120_000), -25_000),
            Arguments.of(GiftEvent(119_999), 0)
        )
    }
}