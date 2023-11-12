package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Validation.validateTotalMenus
import christmas.util.Validation.validateWrongMenuFormat
import christmas.util.Validation.validateWrongDate
import christmas.util.Validation.validateWrongMenuInfo

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
                val input = Console.readLine().replace(" ", "")
                validateWrongMenuFormat(input)
                val order = input.split(",")
                    .map {
                        validateWrongMenuInfo(it)
                    }
                validateTotalMenus(order)
                return order
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}