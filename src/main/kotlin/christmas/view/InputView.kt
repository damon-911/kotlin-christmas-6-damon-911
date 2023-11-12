package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Validation.validateWrongDate
import christmas.util.Validation.validateWrongMenu

class InputView {

    fun readDate(): Int {
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
        while (true) {
            try {
                val input = Console.readLine()
                val order = input.split(",")
                    .map {
                        val menuInfo = it.split("-")
                        validateWrongMenu(menuInfo)
                    }
                return order
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}