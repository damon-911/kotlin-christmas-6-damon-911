package christmas.model.event

import christmas.util.constant.Values

class ChristmasEvent(private val date: Int) : Event {

    override fun getBenefit(): Int {
        if (date in Values.DATE_START.value..Values.DATE_CHRISTMAS.value) {
            return -(Values.DISCOUNT_CHRISTMAS_START.value + (date - 1) * Values.DISCOUNT_CHRISTMAS_EACH_DAY.value)
        }
        return 0
    }
}
