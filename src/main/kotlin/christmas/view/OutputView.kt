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
}