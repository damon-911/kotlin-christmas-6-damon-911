package christmas.view

import christmas.util.constant.Texts

class OutputView {

    fun printGreetings() {
        println(Texts.MESSAGE_START_GREETINGS.text)
    }

    fun printInputDate() {
        println(Texts.MESSAGE_INPUT_DATE.text)
    }

    fun printInputMenu() {
        println(Texts.MESSAGE_INPUT_MENU.text)
    }

    fun printEventBenefits(date: Int) {
        println("12월 ${date}일에 ${Texts.MESSAGE_EVENT_BENEFITS.text}\n")
    }

    fun printOrderedMenu(menu: List<Pair<String, Int>>) {
        println(Texts.MESSAGE_ORDERED_MENU.text)
        menu.forEach {
            println("${it.first} ${it.second}개")
        }
    }
}