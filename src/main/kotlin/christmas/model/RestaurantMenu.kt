package christmas.model

import christmas.util.Texts
import christmas.util.Values

class RestaurantMenu {

    val menus = listOf(
        Menu(Texts.NAME_TAPAS.text, MenuCategory.APPETIZER, Values.PRICE_TAPAS.value),
        Menu(Texts.NAME_SOUP.text, MenuCategory.APPETIZER, Values.PRICE_SOUP.value),
        Menu(Texts.NAME_SALAD.text, MenuCategory.APPETIZER, Values.PRICE_SALAD.value),
        Menu(Texts.NAME_CHRISTMAS_PASTA.text, MenuCategory.MAIN, Values.PRICE_CHRISTMAS_PASTA.value),
        Menu(Texts.NAME_SEAFOOD_PASTA.text, MenuCategory.MAIN, Values.PRICE_SEAFOOD_PASTA.value),
        Menu(Texts.NAME_RIBS.text, MenuCategory.MAIN, Values.PRICE_RIBS.value),
        Menu(Texts.NAME_STEAK.text, MenuCategory.MAIN, Values.PRICE_STEAK.value),
        Menu(Texts.NAME_ICE_CREAM.text, MenuCategory.DESSERT, Values.PRICE_ICE_CREAM.value),
        Menu(Texts.NAME_CHOCOLATE_CAKE.text, MenuCategory.DESSERT, Values.PRICE_CHOCOLATE_CAKE.value),
        Menu(Texts.NAME_ZERO_COLA.text, MenuCategory.BEVERAGE, Values.PRICE_ZERO_COLA.value),
        Menu(Texts.NAME_CHAMPAGNE.text, MenuCategory.BEVERAGE, Values.PRICE_CHAMPAGNE.value),
        Menu(Texts.NAME_RED_WINE.text, MenuCategory.BEVERAGE, Values.PRICE_RED_WINE.value)
    )
}