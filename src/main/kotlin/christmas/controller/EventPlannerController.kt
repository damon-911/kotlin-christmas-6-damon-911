package christmas.controller

import christmas.view.OutputView

class EventPlannerController {

    private val outputView: OutputView by lazy { OutputView() }

    fun startEventPlanner() {
        outputView.printGreetings()
    }
}