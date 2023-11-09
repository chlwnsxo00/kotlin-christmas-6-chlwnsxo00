package christmas.domain

import christmas.constants.isInvalidOrderError

enum class Menu(val menu: String, val price: Int, val type: String) {
    MushroomSoup("양송이수프", 6000, "애피타이저"),
    Tapas("타파스", 5500, "애피타이저"),
    CaesarSalad("시저샐러드", 8000, "애피타이저"),

    TBoneStake("티본스테이크", 55000, "메인"),
    BBQRib("바비큐립", 54000, "메인"),
    SeafoodPasta("해산물파스타", 35000, "메인"),
    ChristmasPasta("크리스마스파스타", 25000, "메인"),

    ChockCake("초코케이크", 15000, "디저트"),
    IceCream("아이스크림", 5000, "디저트"),

    ZeroCola("제로콜라", 3000, "음료"),
    RedWine("레드와인", 60000, "음료"),
    Champagne("샴페인", 25000, "음료");

    companion object {
        fun ofType(menu: String): String {
            return values().firstOrNull { it.menu == menu }?.type
                ?: throw IllegalArgumentException(isInvalidOrderError)
        }

        fun ofPrice(menu: String): Int {
            return values().firstOrNull { it.menu == menu }?.price
                ?: throw IllegalArgumentException(isInvalidOrderError)
        }
    }
}