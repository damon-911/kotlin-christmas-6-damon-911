package christmas.model.event

import christmas.model.menu.MenuCategory
import christmas.model.menu.RestaurantMenu
import christmas.util.constant.Values

class WeekendEvent(private val date: Int, private val menu: List<Pair<String, Int>>) : Event {

    override fun getBenefit(): Int {
        if (date % Values.COUNT_WEEK.value != 1 && date % Values.COUNT_WEEK.value != 2) {
            return 0
        }

        var discount = 0
        menu.forEach {
            if (RestaurantMenu.getMenuCategory(it.first) == MenuCategory.MAIN) {
                discount += -Values.DISCOUNT_WEEKEND_OR_WEEKDAY.value * it.second
            }
        }
        return discount
    }
}
