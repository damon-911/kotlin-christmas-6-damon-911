package christmas.controller

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
        outputView.printEventBenefits(date, menu)
    }
}