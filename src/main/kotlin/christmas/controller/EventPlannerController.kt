package christmas.controller

import christmas.model.RestaurantMenu
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
        showGiftMenu(totalOrderAmount)
        val totalBenefitsAmount = showBenefitsDetail()
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

    private fun showGiftMenu(totalOrderAmount: Int) {
        outputView.printGiftMenu(totalOrderAmount)
    }

    private fun showBenefitsDetail(): Int {
        outputView.printBenefitsDetail()
        var totalDiscount = 0
        totalDiscount += checkChristmasDiscount()
        return totalDiscount
    }

    private fun checkChristmasDiscount(): Int {
        if (date in 1..25) {
            val discount = -(1000 + (date - 1) * 100)
            outputView.printChristmasDiscount(discount)
            return discount
        }
        return 0
    }
}