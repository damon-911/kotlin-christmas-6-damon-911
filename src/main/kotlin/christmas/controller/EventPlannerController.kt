package christmas.controller

import christmas.model.event.*
import christmas.model.menu.RestaurantMenu
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
        val totalOrderAmount = showTotalOrderAmountBeforeDiscount(menu)

        val christmasEvent = ChristmasEvent(date)
        val weekdayEvent = WeekdayEvent(date, menu)
        val weekendEvent = WeekendEvent(date, menu)
        val specialEvent = SpecialEvent(date)
        val giftEvent = GiftEvent(totalOrderAmount)

        val result = EventResult(christmasEvent, weekdayEvent, weekendEvent, specialEvent, giftEvent)

        printEventBenefits(date, menu, totalOrderAmount, result)
    }

    fun showTotalOrderAmountBeforeDiscount(menu: List<Pair<String, Int>>): Int {
        var totalOrderAmount = 0
        menu.forEach {
            totalOrderAmount += RestaurantMenu.getMenuPrice(it.first) * it.second
        }
        return totalOrderAmount
    }

    private fun printEventBenefits(
        date: Int,
        menu: List<Pair<String, Int>>,
        totalOrderAmount: Int,
        result: EventResult
    ) {
        outputView.printEventBenefits(date)
        outputView.printOrderedMenu(menu)
        outputView.printTotalOrderAmountBeforeDiscount(totalOrderAmount)
        outputView.printGiftMenu(result.isGiftRecipient())
        outputView.printBenefitsDetail(result.getBenefitsDetail(), totalOrderAmount, result.getTotalBenefitsAmount())
        outputView.printTotalBenefitsAmount(result.getTotalBenefitsAmount())
        outputView.printTotalOrderAmountAfterDiscount(result.getTotalOrderAmountAfterDiscount(totalOrderAmount))
        outputView.printEventBadge(result.getEventBadge())
    }
}