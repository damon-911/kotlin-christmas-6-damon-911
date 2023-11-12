package christmas.util.constant

enum class MenuInfo(val menuName: String, val price: Int) {
    TAPAS("타파스", 5_500),
    SOUP("양송이수프", 6_000),
    SALAD("시저샐러드", 8_000),

    CHRISTMAS_PASTA("크리스마스파스타", 25_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    RIBS("바비큐립", 54_000),
    STEAK("티본스테이크", 55_000),

    ICE_CREAM("아이스크림", 5_000),
    CHOCOLATE_CAKE("초코케이크", 15_000),

    ZERO_COLA("제로콜라", 3_000),
    CHAMPAGNE("샴페인", 25_000),
    RED_WINE("레드와인", 60_000),
}