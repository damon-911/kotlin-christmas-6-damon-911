package christmas.util.validator

import christmas.model.MenuCategory
import christmas.model.RestaurantMenu
import christmas.util.constant.Texts
import christmas.util.constant.Values

object Validation {

    fun validateWrongDate(input: String): Int {
        val num = input.trim().toIntOrNull() ?: throw NumberFormatException(Texts.EXCEPTION_WRONG_DATE.text)
        require(num in Values.DATE_START.value..Values.DATE_END.value) {
            Texts.EXCEPTION_WRONG_DATE.text
        }
        return num
    }

    fun validateWrongMenuFormat(input: String) {
        require(input.matches(Regex("[a-zA-Z]+-[0-9]+(,[a-zA-Z]+-[0-9]+)*"))) {
            Texts.EXCEPTION_WRONG_MENU.text
        }
    }

    fun validateWrongMenuInfo(menu: String): Pair<String, Int> {
        val menuInfo = menu.split("-")
        val menuName = validateMenuName(menuInfo[0])
        val menuCount = validateMenuCount(menuInfo[1])
        return Pair(menuName, menuCount)
    }

    private fun validateMenuName(menuName: String): String {
        require(RestaurantMenu.isMenuExist(menuName)) {
            Texts.EXCEPTION_WRONG_MENU.text
        }
        return menuName
    }

    private fun validateMenuCount(menuCount: String): Int {
        val count = menuCount.toIntOrNull() ?: throw NumberFormatException(Texts.EXCEPTION_WRONG_MENU.text)
        require(count in Values.COUNT_MIN_MENU.value..Values.COUNT_MAX_MENU.value) {
            Texts.EXCEPTION_WRONG_MENU.text
        }
        return count
    }

    fun validateTotalMenus(order: List<Pair<String, Int>>) {
        validateDuplicateMenus(order)
        validateOnlyBeverage(order)
        validateTotalQuantity(order)
    }

    private fun validateDuplicateMenus(order: List<Pair<String, Int>>) {
        val menuSet = mutableSetOf<String>()
        order.forEach { (menu, _) ->
            require(menuSet.add(menu)) {
                Texts.EXCEPTION_WRONG_MENU.text
            }
        }
    }

    private fun validateOnlyBeverage(order: List<Pair<String, Int>>) {
        val beverageCategories = setOf(MenuCategory.BEVERAGE)
        val categories = order.map { (menu, _) ->
            RestaurantMenu.getMenuCategory(menu)
        }.toSet()
        require(categories != beverageCategories) {
            Texts.EXCEPTION_WRONG_MENU.text
        }
    }

    private fun validateTotalQuantity(order: List<Pair<String, Int>>) {
        val totalQuantity = order.sumOf { it.second }
        require(totalQuantity <= 20) {
            Texts.EXCEPTION_WRONG_MENU.text
        }
    }
}