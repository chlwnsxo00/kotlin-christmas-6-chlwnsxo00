package christmas.domain

import christmas.constants.appetizer
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
            if (Menu.ofType(menu.key) == appetizer)
                discount -= 2023
        }
        return discount
    }

    fun weekendDiscountCompute(result: Map<String, Int>): Int {
        var discount = 0
        for (menu in result) {
            if (Menu.ofType(menu.key) == main)
                discount -= 2023
        }
        return discount
    }

}