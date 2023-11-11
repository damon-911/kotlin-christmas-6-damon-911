package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Texts
import christmas.util.Validation.validateWrongDate
import christmas.util.Validation.validateWrongMenu

class InputView {

    fun readDate(): Int {
        println(Texts.MESSAGE_INPUT_DATE.text)
        while (true) {
            try {
                val input = Console.readLine()
                return validateWrongDate(input)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun readMenu(): List<Pair<String, Int>> {
        println(Texts.MESSAGE_INPUT_MENU.text)
        while (true) {
            try {
                val input = Console.readLine()
                return validateWrongMenu(input)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}