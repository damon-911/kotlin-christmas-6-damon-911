package christmas.util.constant

enum class Texts(val text: String) {
    // MESSAGE
    MESSAGE_START_GREETINGS("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    MESSAGE_INPUT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MESSAGE_INPUT_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    MESSAGE_EVENT_BENEFITS("우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    MESSAGE_ORDERED_MENU("<주문 메뉴>"),
    MESSAGE_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    MESSAGE_GIFT_MENU("<증정 메뉴>"),
    MESSAGE_BENEFITS_DETAIL("<혜택 내역>"),
    MESSAGE_TOTAL_BENEFITS_AMOUNT("<총혜택 금액>"),
    MESSAGE_TOTAL_ORDER_AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    MESSAGE_EVENT_BADGE("<12월 이벤트 배지>"),

    MESSAGE_GIFT("샴페인 1개"),
    MESSAGE_NONE("없음"),

    MESSAGE_BENEFITS_CHRISTMAS("크리스마스 디데이 할인: "),
    MESSAGE_BENEFITS_WEEKEND("주말 할인: "),
    MESSAGE_BENEFITS_WEEKDAY("평일 할인: "),
    MESSAGE_BENEFITS_SPECIAL("특별 할인: -1,000원"),
    MESSAGE_BENEFITS_GIFT("증정 이벤트: -25,000원"),

    // BADGE
    BADGE_SANTA("산타"),
    BADGE_TREE("트리"),
    BADGE_STAR("별"),

    // EXCEPTION
    EXCEPTION_WRONG_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    EXCEPTION_WRONG_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
}