package christmas.view

import christmas.util.constant.Texts
import christmas.util.constant.Values

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

    fun printNone() {
        println(Texts.MESSAGE_NONE.text)
    }

    fun printEventBenefits(date: Int) {
        println("12월 ${date}일에 ${Texts.MESSAGE_EVENT_BENEFITS.text}")
    }

    fun printOrderedMenu(menu: List<Pair<String, Int>>) {
        println("\n" + Texts.MESSAGE_ORDERED_MENU.text)
        menu.forEach {
            println("${it.first} ${it.second}개")
        }
    }

    fun printTotalOrderAmountBeforeDiscount(totalAmount: Int) {
        println("\n" + Texts.MESSAGE_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.text)
        println(String.format("%,d원", totalAmount))
    }

    fun printGiftMenu(flag: Boolean) {
        println("\n" + Texts.MESSAGE_GIFT_MENU.text)
        if (flag) {
            println(Texts.MESSAGE_GIFT.text)
            return
        }
        printNone()
    }

    fun printBenefitsDetail(benefitsMap: Map<String, Int>, totalOrderAmount: Int, totalBenefitsAmount: Int) {
        println("\n" + Texts.MESSAGE_BENEFITS_DETAIL.text)
        if (totalOrderAmount < Values.PRICE_EVENT_THRESHOLD.value || totalBenefitsAmount == 0) {
            printNone()
            return
        }
        benefitsMap.forEach { (benefit, amount) ->
            if (amount != 0) {
                println("$benefit: " + String.format("%,d원", amount))
            }
        }
    }

    fun printTotalBenefitsAmount(totalBenefitsAmount: Int) {
        println("\n" + Texts.MESSAGE_TOTAL_BENEFITS_AMOUNT.text)
        println(String.format("%,d원", totalBenefitsAmount))
    }

    fun printTotalOrderAmountAfterDiscount(totalAmount: Int) {
        println("\n" + Texts.MESSAGE_TOTAL_ORDER_AMOUNT_AFTER_DISCOUNT.text)
        println(String.format("%,d원", totalAmount))
    }

    fun printEventBadge(badge: String) {
        println("\n" + Texts.MESSAGE_EVENT_BADGE.text)
        println(badge)
    }
}