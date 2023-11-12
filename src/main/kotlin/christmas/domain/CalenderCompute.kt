package christmas.domain

import christmas.constants.dessert
import christmas.constants.main

class CalenderCompute {

    fun christmasDDayDiscountCompute(date: Int): Int {
        var discount = 0
        if (date <= 25) {
            discount -= 1000 + 100 * (date - 1)
        }
        return discount
    }

    fun weekdayDiscountCompute(result: Map<String, Int>): Int {
        var discount = 0
        for (menu in result) {
            if (Menu.ofType(menu.key) == dessert)
                discount -= menu.value * 2023
        }
        return discount
    }

    fun weekendDiscountCompute(result: Map<String, Int>): Int {
        var discount = 0
        for (menu in result) {
            if (Menu.ofType(menu.key) == main)
                discount -= menu.value * 2023
        }
        return discount
    }

    fun decideBadge(totalDiscount: Int): String {
        when {
            -totalDiscount >= 20000 -> return "산타"
            -totalDiscount >= 10000 -> return "트리"
            -totalDiscount >= 5000 -> return "별"
        }
        return "없음"
    }
}