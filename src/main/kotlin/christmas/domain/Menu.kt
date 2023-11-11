package christmas.domain

import christmas.constants.appetizer
import christmas.constants.dessert
import christmas.constants.drink
import christmas.constants.isInvalidOrderError
import christmas.constants.main

enum class Menu(val menu: String, val price: Int, val type: Int) {
    MushroomSoup("양송이수프", 6000, appetizer),
    Tapas("타파스", 5500, appetizer),
    CaesarSalad("시저샐러드", 8000, appetizer),

    TBoneStake("티본스테이크", 55000, main),
    BBQRib("바비큐립", 54000, main),
    SeafoodPasta("해산물파스타", 35000, main),
    ChristmasPasta("크리스마스파스타", 25000, main),

    ChockCake("초코케이크", 15000, dessert),
    IceCream("아이스크림", 5000, dessert),

    ZeroCola("제로콜라", 3000, drink),
    RedWine("레드와인", 60000, drink),
    Champagne("샴페인", 25000, drink);

    companion object {

        fun checkExistMenu(menu: String) {
            values().firstOrNull { it.menu == menu }
                ?: throw IllegalArgumentException(isInvalidOrderError)
        }

        fun ofType(menu: String): Int {
            return values().first { it.menu == menu }.type
        }

        fun ofPrice(menu: String): Int {
            return values().first { it.menu == menu }.price
        }
    }
}