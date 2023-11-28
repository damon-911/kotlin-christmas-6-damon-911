package christmas.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
}