package christmas.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class EventPlannerControllerTest {

    private lateinit var controller: EventPlannerController

    @BeforeEach
    fun setUp() {
        controller = EventPlannerController()
    }

    @Test
    fun `할인 전 총주문 금액은 각 메뉴의 가격과 개수의 곱과 같습니다`() {
        val menu = listOf(Pair("양송이수프", 5), Pair("해산물파스타", 1), Pair("아이스크림", 3))
        assertEquals(80_000, controller.showTotalOrderAmountBeforeDiscount(menu))
    }

    @Test
    fun `증정 메뉴는 할인 전 총주문 금액이 120,000원 이상일 경우 제공됩니다`() {
        val totalOrderAmount = 120_000
        assertTrue(controller.showGiftMenu(totalOrderAmount))
    }

    @Test
    fun `증정 메뉴는 할인 전 총주문 금액이 120,000원 미만일 경우 제공되지 않습니다`() {
        val totalOrderAmount = 110_000
        assertFalse(controller.showGiftMenu(totalOrderAmount))
    }

    @ParameterizedTest
    @CsvSource(value = ["3,-1200", "15,-2400", "27,0"])
    fun `크리스마스 디데이 할인 테스트`(input: Int, expected: Int) {
        assertEquals(expected, controller.checkChristmasDiscount(input))
    }

    @ParameterizedTest
    @MethodSource("provideDateAndMenu")
    fun `평일 할인 또는 주말 할인 테스트`(expected: Int, date: Int, menu: List<Pair<String, Int>>) {
        assertEquals(expected, controller.checkWeekdayOrWeekendDiscount(date, menu))
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 10, 17, 25])
    fun `특별 할인 테스트`(date: Int) {
        assertNotEquals(0, controller.checkSpecialDiscount(date))
    }

    @Test
    fun `증정 이벤트 테스트`() {
        assertNotEquals(0, controller.checkGiftEvent(true))
    }

    companion object {
        @JvmStatic
        fun provideDateAndMenu(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    -6_069,
                    3,
                    listOf(Pair("시저샐러드", 1), Pair("바비큐립", 2), Pair("초코케이크", 3))
                ),
                Arguments.of(
                    -4_046,
                    15,
                    listOf(Pair("시저샐러드", 1), Pair("바비큐립", 2), Pair("초코케이크", 3))
                )
            )
        }
    }
}