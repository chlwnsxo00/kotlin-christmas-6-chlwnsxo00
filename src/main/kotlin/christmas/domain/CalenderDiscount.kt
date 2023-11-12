package christmas.domain


class CalenderDiscount(private val date: Int, private val result: Map<String, Int>) {
    private val compute = CalenderCompute()
    private val day = CalenderDay(date)
    fun christmasDDayDiscount(): Int {
        return compute.christmasDDayDiscountCompute(date)
    }

    fun weekdayDiscount(): Int {
        var discount = 0
        if (day.isWeekend().not()) {
            discount = compute.weekdayDiscountCompute(result)
        }
        return discount
    }

    fun weekendDiscount(): Int {
        var discount = 0
        if (day.isWeekend()) {
            discount = compute.weekendDiscountCompute(result)
        }
        return discount
    }

    fun specialDiscount(): Int {
        var discount = 0
        if (day.isSpecialDay()) {
            discount = -1000
        }
        return discount
    }

    fun presentationDiscount(): Int {
        var discount = 0
        if (getTotalPrice()>=120000) {
            discount -= Menu.ofPrice("샴페인")
        }
        return discount
    }

    private fun getTotalPrice(): Int {
        return result.entries.sumOf { Menu.ofPrice(it.key) * it.value }
    }
}