package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Messages

class InputView {

    fun readDate(): Int {
        println(Messages.TEXT_INPUT_DATE.message)
        val input = Console.readLine()
        return input.toInt()
    }
}