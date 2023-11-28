package christmas.model.event

import christmas.util.constant.Values

class SpecialEvent(private val date: Int) : Event {

    override fun getBenefit(): Int {
        if (date % Values.COUNT_WEEK.value == 3 || date == Values.DATE_CHRISTMAS.value) {
            return -Values.DISCOUNT_SPECIAL.value
        }
        return 0
    }
}
