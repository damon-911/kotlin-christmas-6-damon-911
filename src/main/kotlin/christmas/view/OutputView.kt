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

    fun printBenefitsDetail() {
        println("\n" + Texts.MESSAGE_BENEFITS_DETAIL.text)
    }

    fun printChristmasDiscount(discount: Int) {
        println(Texts.MESSAGE_BENEFITS_CHRISTMAS.text + String.format("%,d원", discount))
    }

    fun printWeekendDiscount(discount: Int) {
        println(Texts.MESSAGE_BENEFITS_WEEKEND.text + String.format("%,d원", discount))
    }

    fun printWeekdayDiscount(discount: Int) {
        println(Texts.MESSAGE_BENEFITS_WEEKDAY.text + String.format("%,d원", discount))
    }

    fun printSpecialDiscount() {
        println(Texts.MESSAGE_BENEFITS_SPECIAL.text)
    }

    fun printGiftEvent() {
        println(Texts.MESSAGE_BENEFITS_GIFT.text)
    }

    fun printTotalBenefitsAmount(totalBenefitsAmount: Int) {
        println("\n" + Texts.MESSAGE_TOTAL_BENEFITS_AMOUNT.text)
        if (totalBenefitsAmount != 0) {
            println(String.format("%,d원", totalBenefitsAmount))
            return
        }
        printNone()
    }
}