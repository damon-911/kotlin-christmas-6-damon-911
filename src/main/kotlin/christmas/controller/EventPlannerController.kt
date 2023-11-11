package christmas.controller

import christmas.view.InputView
import christmas.view.OutputView

class EventPlannerController {

    private val inputView: InputView by lazy { InputView() }
    private val outputView: OutputView by lazy { OutputView() }

    fun startEventPlanner() {
        outputView.printGreetings()
        val date = inputView.readDate()
        println(date)
    }
}