package christmas.domain

import christmas.view.output.OutputView

class CalenderDiscount(private val day: CalenderDay, private val result: Map<String, Int>) {
    private val output = OutputView()
    private val compute = CalenderCompute()
    private var totalDiscount = 0
    private val totalPrice = result.entries.sumOf { Menu.ofPrice(it.key) * it.value }
    fun christmasDDayDiscount() {
        val discount = compute.christmasDDayDiscountCompute(day.getdate())
        totalDiscount += discount
        output.printChristmasDDayDiscountResult(discount)
    }

    fun weekdayDiscount() {
        if (day.isWeekend().not()) {
            val discount = compute.weekdayDiscountCompute(result)
            totalDiscount += discount
            output.printWeekdayDiscountResult(discount)
        }
    }

    fun weekendDiscount() {
        if (day.isWeekend()) {
            val discount = compute.weekendDiscountCompute(result)
            totalDiscount += discount
            output.printWeekendDiscountResult(discount)
        }
    }

    fun specialDiscount() {
        if (day.isSpecialDay()) {
            val discount = -1000
            totalDiscount += discount
            output.printSpecialDiscountResult(discount)
        }
    }

    fun presentationDiscount() {
        if (isTotalPriceOver120000()) {
            val discount = -25000
            totalDiscount += discount
            output.presentationDiscount(discount)
        }
    }

    fun isTotalPriceOver120000():Boolean{
        return totalPrice >= 120000
    }

}