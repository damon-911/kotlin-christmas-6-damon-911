package christmas.util

enum class Texts(val text: String) {
    // MESSAGE
    MESSAGE_START_GREETINGS("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    MESSAGE_INPUT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MESSAGE_INPUT_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    // EXCEPTION
    EXCEPTION_WRONG_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    // MENU
    NAME_TAPAS("타파스"),
    NAME_SOUP("양송이수프"),
    NAME_SALAD("시저샐러드"),

    NAME_CHRISTMAS_PASTA("크리스마스파스타"),
    NAME_SEAFOOD_PASTA("해산물파스타"),
    NAME_RIBS("해산물파스타"),
    NAME_STEAK("티본스테이크"),

    NAME_ICE_CREAM("아이스크림"),
    NAME_CHOCOLATE_CAKE("초코케이크"),

    NAME_ZERO_COLA("제로콜라"),
    NAME_CHAMPAGNE("샴페인"),
    NAME_RED_WINE("레드와인"),
}