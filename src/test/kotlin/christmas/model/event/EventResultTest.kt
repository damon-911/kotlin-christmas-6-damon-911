package christmas.model.event

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EventResultTest {

    private lateinit var eventResult: EventResult

    @BeforeEach
    fun setUp() {
        eventResult = EventResult(
            ChristmasEvent(date),
            WeekdayEvent(date, menu),
            WeekendEvent(date, menu),
            SpecialEvent(date),
            GiftEvent(totalOrderAmount)
        )
    }

    @Test
    fun `증정 메뉴는 할인 전 총주문 금액이 120,000원 이상일 경우 제공됩니다`() {
        assertTrue(eventResult.isGiftRecipient())
    }

    @Test
    fun `총혜택 금액 테스트`() {
        eventResult.getBenefitsDetail()
        assertEquals(-33_269, eventResult.getTotalBenefitsAmount())
    }

    @Test
    fun `할인 후 예상 결제 금액 테스트`() {
        eventResult.getBenefitsDetail()
        assertEquals(152_731, eventResult.getTotalOrderAmountAfterDiscount(totalOrderAmount))
    }

    @Test
    fun `이벤트 배지 테스트`() {
        eventResult.getBenefitsDetail()
        assertEquals("산타", eventResult.getEventBadge())
    }

    companion object {
        private const val date = 3
        private val menu =  listOf(Pair("시저샐러드", 1), Pair("바비큐립", 2), Pair("초코케이크", 3))
        private const val totalOrderAmount = 161_000
    }
}