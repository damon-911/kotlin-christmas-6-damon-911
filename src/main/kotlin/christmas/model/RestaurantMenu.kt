package christmas.model

import christmas.util.MenuInfo

class RestaurantMenu {

    val menus = listOf(
        Menu(MenuInfo.TAPAS.menuName, MenuCategory.APPETIZER, MenuInfo.TAPAS.price),
        Menu(MenuInfo.SOUP.menuName, MenuCategory.APPETIZER, MenuInfo.SOUP.price),
        Menu(MenuInfo.SALAD.menuName, MenuCategory.APPETIZER, MenuInfo.SALAD.price),
        Menu(MenuInfo.CHRISTMAS_PASTA.menuName, MenuCategory.MAIN, MenuInfo.CHRISTMAS_PASTA.price),
        Menu(MenuInfo.SEAFOOD_PASTA.menuName, MenuCategory.MAIN, MenuInfo.SEAFOOD_PASTA.price),
        Menu(MenuInfo.RIBS.menuName, MenuCategory.MAIN, MenuInfo.RIBS.price),
        Menu(MenuInfo.STEAK.menuName, MenuCategory.MAIN, MenuInfo.STEAK.price),
        Menu(MenuInfo.ICE_CREAM.menuName, MenuCategory.DESSERT, MenuInfo.ICE_CREAM.price),
        Menu(MenuInfo.CHOCOLATE_CAKE.menuName, MenuCategory.DESSERT, MenuInfo.CHOCOLATE_CAKE.price),
        Menu(MenuInfo.ZERO_COLA.menuName, MenuCategory.BEVERAGE, MenuInfo.ZERO_COLA.price),
        Menu(MenuInfo.CHAMPAGNE.menuName, MenuCategory.BEVERAGE, MenuInfo.CHAMPAGNE.price),
        Menu(MenuInfo.RED_WINE.menuName, MenuCategory.BEVERAGE, MenuInfo.RED_WINE.price)
    )
}