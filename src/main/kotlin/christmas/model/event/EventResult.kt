package christmas.model.event

import christmas.util.constant.Texts
import christmas.util.constant.Values

class EventResult(
    private val christmasEvent: ChristmasEvent,
    private val weekdayEvent: WeekdayEvent,
    private val weekendEvent: WeekendEvent,
    private val specialEvent: SpecialEvent,
    private val giftEvent: GiftEvent,
) {

    private var totalBenefitsAmount = 0

    fun getTotalBenefitsAmount(): Int {
        return totalBenefitsAmount
    }

    fun isGiftRecipient(): Boolean {
        if (giftEvent.getBenefit() == 0)
            return false
        return true
    }

    fun getBenefitsDetail(): Map<String, Int> {
        val benefitsDetail = mutableMapOf<String, Int>()
        benefitsDetail[Texts.MESSAGE_BENEFITS_CHRISTMAS.text] = christmasEvent.getBenefit()
        benefitsDetail[Texts.MESSAGE_BENEFITS_WEEKDAY.text] = weekdayEvent.getBenefit()
        benefitsDetail[Texts.MESSAGE_BENEFITS_WEEKEND.text] = weekendEvent.getBenefit()
        benefitsDetail[Texts.MESSAGE_BENEFITS_SPECIAL.text] = specialEvent.getBenefit()
        benefitsDetail[Texts.MESSAGE_BENEFITS_GIFT.text] = giftEvent.getBenefit()

        benefitsDetail.forEach { (_, amount) ->
            totalBenefitsAmount += amount
        }

        return benefitsDetail
    }

    fun getTotalOrderAmountAfterDiscount(totalAmount: Int): Int {
        if (isGiftRecipient()) {
            return totalAmount + totalBenefitsAmount + Values.PRICE_GIFT_EVENT.value
        }
        return totalAmount + totalBenefitsAmount
    }

    fun getEventBadge(): String {
        return when {
            totalBenefitsAmount <= -20_000 -> Texts.BADGE_SANTA.text
            totalBenefitsAmount <= -10_000 -> Texts.BADGE_TREE.text
            totalBenefitsAmount <= -5_000 -> Texts.BADGE_STAR.text
            else -> Texts.MESSAGE_NONE.text
        }
    }
}