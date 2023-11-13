package christmas.controller

import christmas.model.MenuCategory
import christmas.model.RestaurantMenu
import christmas.util.constant.Texts
import christmas.util.constant.Values
import christmas.view.InputView
import christmas.view.OutputView

class EventPlannerController {

    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    fun startEventPlanner() {
        outputView.printGreetings()
        val date = inputDate()
        val menu = inputMenu()
        showEventBenefits(date, menu)
    }

    private fun inputDate(): Int {
        outputView.printInputDate()
        return inputView.readDate()
    }

    private fun inputMenu(): List<Pair<String, Int>> {
        outputView.printInputMenu()
        return inputView.readMenu()
    }

    private fun showEventBenefits(date: Int, menu: List<Pair<String, Int>>) {
        outputView.printEventBenefits(date)
        showOrderedMenu(menu)
        val totalOrderAmount = showTotalOrderAmountBeforeDiscount(menu)
        val flag = showGiftMenu(totalOrderAmount)
        val totalBenefitsAmount = showBenefitsDetail(date, menu, totalOrderAmount, flag)
        showTotalBenefitsAmount(totalBenefitsAmount)
        showTotalOrderAmountAfterDiscount(totalOrderAmount + totalBenefitsAmount, flag)
        showEventBadge(totalBenefitsAmount)
    }

    private fun showOrderedMenu(menu: List<Pair<String, Int>>) {
        outputView.printOrderedMenu(menu)
    }

    fun showTotalOrderAmountBeforeDiscount(menu: List<Pair<String, Int>>): Int {
        var total = 0
        menu.forEach {
            total += RestaurantMenu.getMenuPrice(it.first) * it.second
        }
        outputView.printTotalOrderAmountBeforeDiscount(total)
        return total
    }

    fun showGiftMenu(totalOrderAmount: Int): Boolean {
        if (totalOrderAmount >= Values.PRICE_GIFT_THRESHOLD.value) {
            outputView.printGiftMenu(true)
            return true
        }
        outputView.printGiftMenu(false)
        return false
    }

    private fun showBenefitsDetail(
        date: Int,
        menu: List<Pair<String, Int>>,
        totalOrderAmount: Int,
        flag: Boolean
    ): Int {
        outputView.printBenefitsDetail()
        if (totalOrderAmount < Values.PRICE_EVENT_THRESHOLD.value) {
            outputView.printNone()
            return 0
        }
        var totalDiscount = 0
        totalDiscount += checkChristmasDiscount(date)
        totalDiscount += checkWeekdayOrWeekendDiscount(date, menu)
        totalDiscount += checkSpecialDiscount(date)
        totalDiscount += checkGiftEvent(flag)
        if (totalDiscount == 0) {
            outputView.printNone()
        }
        return totalDiscount
    }

    fun checkChristmasDiscount(date: Int): Int {
        if (date in Values.DATE_START.value..Values.DATE_CHRISTMAS.value) {
            val discount =
                -(Values.DISCOUNT_CHRISTMAS_START.value + (date - 1) * Values.DISCOUNT_CHRISTMAS_EACH_DAY.value)
            outputView.printChristmasDiscount(discount)
            return discount
        }
        return 0
    }

    fun checkWeekdayOrWeekendDiscount(date: Int, menu: List<Pair<String, Int>>): Int {
        if (date % Values.COUNT_WEEK.value == 1 || date % Values.COUNT_WEEK.value == 2) {
            return checkWeekendDiscount(menu)
        }
        return checkWeekdayDiscount(menu)
    }

    private fun checkWeekendDiscount(menu: List<Pair<String, Int>>): Int {
        var discount = 0
        menu.forEach {
            if (RestaurantMenu.getMenuCategory(it.first) == MenuCategory.MAIN) {
                discount += -Values.DISCOUNT_WEEKEND_OR_WEEKDAY.value * it.second
            }
        }
        if (discount != 0) {
            outputView.printWeekendDiscount(discount)
        }
        return discount
    }

    private fun checkWeekdayDiscount(menu: List<Pair<String, Int>>): Int {
        var discount = 0
        menu.forEach {
            if (RestaurantMenu.getMenuCategory(it.first) == MenuCategory.DESSERT) {
                discount += -Values.DISCOUNT_WEEKEND_OR_WEEKDAY.value * it.second
            }
        }
        if (discount != 0) {
            outputView.printWeekdayDiscount(discount)
        }
        return discount
    }

    fun checkSpecialDiscount(date: Int): Int {
        if (date % Values.COUNT_WEEK.value == 3 || date == Values.DATE_CHRISTMAS.value) {
            outputView.printSpecialDiscount()
            return -Values.DISCOUNT_SPECIAL.value
        }
        return 0
    }

    fun checkGiftEvent(flag: Boolean): Int {
        if (flag) {
            outputView.printGiftEvent()
            return -Values.PRICE_GIFT_EVENT.value
        }
        return 0
    }

    private fun showTotalBenefitsAmount(totalBenefitsAmount: Int) {
        outputView.printTotalBenefitsAmount(totalBenefitsAmount)
    }

    private fun showTotalOrderAmountAfterDiscount(totalAmount: Int, flag: Boolean) {
        if (flag) {
            outputView.printTotalOrderAmountAfterDiscount(totalAmount + Values.PRICE_GIFT_EVENT.value)
            return
        }
        outputView.printTotalOrderAmountAfterDiscount(totalAmount)
    }

    private fun showEventBadge(totalBenefitsAmount: Int) {
        val badge = when {
            totalBenefitsAmount <= -20_000 -> Texts.BADGE_SANTA.text
            totalBenefitsAmount <= -10_000 -> Texts.BADGE_TREE.text
            totalBenefitsAmount <= -5_000 -> Texts.BADGE_STAR.text
            else -> Texts.MESSAGE_NONE.text
        }
        outputView.printEventBadge(badge)
    }
}