package christmas.controller

import christmas.view.InputView
import christmas.view.OutputView

class EventPlannerController {

    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    fun startEventPlanner() {
        outputView.printGreetings()
        inputDate()
        inputMenu()
    }

    private fun inputDate() {
        outputView.printInputDate()
        val date = inputView.readDate()
    }

    private fun inputMenu() {
        outputView.printInputMenu()
        val menu = inputView.readMenu()
    }
}