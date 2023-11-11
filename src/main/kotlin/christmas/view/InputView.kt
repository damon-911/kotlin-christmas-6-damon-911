package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Messages
import christmas.util.Validation.validateWrongDate

class InputView {

    fun readDate(): Int {
        println(Messages.TEXT_INPUT_DATE.message)
        while (true) {
            try {
                val input = Console.readLine()
                return validateWrongDate(input)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun readMenu(): String {
        println(Messages.TEXT_INPUT_MENU.message)
        while (true) {
            try {
                val input = Console.readLine()
                return input
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}