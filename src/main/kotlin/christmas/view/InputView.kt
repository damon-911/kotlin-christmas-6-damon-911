package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.validator.Validation.validateTotalMenus
import christmas.util.validator.Validation.validateWrongMenuFormat
import christmas.util.validator.Validation.validateWrongDate
import christmas.util.validator.Validation.validateWrongMenuInfo
import java.lang.IllegalArgumentException

class InputView {

    fun readDate(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                return validateWrongDate(input)
            } catch (e: IllegalArgumentException) {
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
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}