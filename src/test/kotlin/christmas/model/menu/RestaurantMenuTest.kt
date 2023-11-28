package christmas.model.menu

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RestaurantMenuTest {

    @Test
    fun `초코케이크는 식당 메뉴에 존재합니다`() {
        assertTrue { RestaurantMenu.isMenuExist("초코케이크") }
    }

    @Test
    fun `생크림케이크는 식당 메뉴에 존재하지 않습니다`() {
        assertFalse { RestaurantMenu.isMenuExist("생크림케이크") }
    }

    @Test
    fun `시저샐러드는 애피타이저에 속합니다`() {
        assertEquals(MenuCategory.APPETIZER, RestaurantMenu.getMenuCategory("시저샐러드"))
    }

    @Test
    fun `치킨샐러드는 메뉴에 없는 음식이기 때문에 예외가 발생합니다`() {
        assertThrows<IllegalArgumentException> {
            RestaurantMenu.getMenuCategory("치킨샐러드")
        }
    }
}