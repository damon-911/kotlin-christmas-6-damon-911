package christmas.model.event

import christmas.util.constant.Values

class GiftEvent(private val totalOrderAmount: Int) : Event {

    override fun getBenefit(): Int {
        if (totalOrderAmount >= Values.PRICE_GIFT_THRESHOLD.value) {
            return -Values.PRICE_GIFT_EVENT.value
        }
        return 0
    }
}
