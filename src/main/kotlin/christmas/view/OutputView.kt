package christmas.view

import christmas.model.RestaurantMenu
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

    fun printEventBenefits(date: Int, menu: List<Pair<String, Int>>) {
        println("12월 ${date}일에 ${Texts.MESSAGE_EVENT_BENEFITS.text}")
        printOrderedMenu(menu)
        val flag = printTotalOrderAmountBeforeDiscount(menu)
        printGiftMenu(flag)
        printBenefitsDetail(date, menu)
    }

    private fun printOrderedMenu(menu: List<Pair<String, Int>>) {
        println("\n" + Texts.MESSAGE_ORDERED_MENU.text)
        menu.forEach {
            println("${it.first} ${it.second}개")
        }
    }

    private fun printTotalOrderAmountBeforeDiscount(menu: List<Pair<String, Int>>): Boolean {
        println("\n" + Texts.MESSAGE_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.text)
        var totalAmount = 0
        menu.forEach {
            totalAmount += RestaurantMenu.getMenuPrice(it.first) * it.second
        }
        println(String.format("%,d원", totalAmount))
        return totalAmount >= 120_000
    }

    private fun printGiftMenu(flag: Boolean) {
        println("\n" + Texts.MESSAGE_GIFT_MENU.text)
        if (flag) {
            println(Texts.MESSAGE_GIFT.text)
            return
        }
        println(Texts.MESSAGE_NONE.text)
    }

    private fun printBenefitsDetail(date: Int, menu: List<Pair<String, Int>>) {
        println("\n" + Texts.MESSAGE_BENEFITS_DETAIL.text)
        var totalDiscount = 0
        totalDiscount += checkChristmasDiscount(date)
    }

    private fun checkChristmasDiscount(date: Int): Int {
        val discount = -(1000 + (date - 1) * 100)
        if (date in 1..25) {
            println(Texts.MESSAGE_BENEFITS_CHRISTMAS.text + String.format("%,d원", discount))
        }
        return discount
    }
}