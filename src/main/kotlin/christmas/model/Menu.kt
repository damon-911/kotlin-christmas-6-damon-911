package christmas.model

data class Menu(
    val name: String,
    val category: MenuCategory,
    val price: Int
)

enum class MenuCategory {
    APPETIZER,
    MAIN,
    DESSERT,
    BEVERAGE
}