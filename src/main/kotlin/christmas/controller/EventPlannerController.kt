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

    private lateinit var menu: List<Pair<String, Int>>
    private var date = 0

    fun startEventPlanner() {
        outputView.printGreetings()
        inputDate()
        inputMenu()
        showEventBenefits()
    }

    private fun inputDate() {
        outputView.printInputDate()
        date = inputView.readDate()
    }

    private fun inputMenu() {
        outputView.printInputMenu()
        menu = inputView.readMenu()
    }

    private fun showEventBenefits() {
        outputView.printEventBenefits(date)
        showOrderedMenu()
        val totalOrderAmount = showTotalOrderAmountBeforeDiscount()
        val flag = showGiftMenu(totalOrderAmount)
        val totalBenefitsAmount = showBenefitsDetail(flag)
        showTotalBenefitsAmount(totalBenefitsAmount)
        showTotalOrderAmountAfterDiscount(totalOrderAmount + totalBenefitsAmount, flag)
        showEventBadge(totalBenefitsAmount)
    }

    private fun showOrderedMenu() {
        outputView.printOrderedMenu(menu)
    }

    private fun showTotalOrderAmountBeforeDiscount(): Int {
        var total = 0
        menu.forEach {
            total += RestaurantMenu.getMenuPrice(it.first) * it.second
        }
        outputView.printTotalOrderAmountBeforeDiscount(total)
        return total
    }

    private fun showGiftMenu(totalOrderAmount: Int): Boolean {
        if (totalOrderAmount >= Values.PRICE_GIFT_THRESHOLD.value) {
            outputView.printGiftMenu(true)
            return true
        }
        outputView.printGiftMenu(false)
        return false
    }

    private fun showBenefitsDetail(flag: Boolean): Int {
        outputView.printBenefitsDetail()
        var totalDiscount = 0
        totalDiscount += checkChristmasDiscount()
        totalDiscount += checkWeekdayOrWeekendDiscount()
        totalDiscount += checkSpecialDiscount()
        totalDiscount += checkGiftEvent(flag)
        if (totalDiscount == 0) {
            outputView.printNone()
        }
        return totalDiscount
    }

    private fun checkChristmasDiscount(): Int {
        if (date in Values.DATE_START.value..Values.DATE_CHRISTMAS.value) {
            val discount =
                -(Values.DISCOUNT_CHRISTMAS_START.value + (date - 1) * Values.DISCOUNT_CHRISTMAS_EACH_DAY.value)
            outputView.printChristmasDiscount(discount)
            return discount
        }
        return 0
    }

    private fun checkWeekdayOrWeekendDiscount(): Int {
        if (date % Values.COUNT_WEEK.value == 1 || date % Values.COUNT_WEEK.value == 2) {
            return checkWeekendDiscount()
        }
        return checkWeekdayDiscount()
    }

    private fun checkWeekendDiscount(): Int {
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

    private fun checkWeekdayDiscount(): Int {
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

    private fun checkSpecialDiscount(): Int {
        if (date % Values.COUNT_WEEK.value == 3 || date == Values.DATE_CHRISTMAS.value) {
            outputView.printSpecialDiscount()
            return -Values.DISCOUNT_SPECIAL.value
        }
        return 0
    }

    private fun checkGiftEvent(flag: Boolean): Int {
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