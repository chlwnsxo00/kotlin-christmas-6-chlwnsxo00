package christmas.domain


class CalenderDiscount(private val day: CalenderDay, private val result: Map<String, Int>) {
    private val compute = CalenderCompute()
    private var totalDiscount = 0
    fun christmasDDayDiscount(): Int {
        val discount = compute.christmasDDayDiscountCompute(day.getDate())
        totalDiscount += discount
        return discount
    }

    fun weekdayDiscount(): Int {
        var discount = 0
        if (day.isWeekend().not()) {
            discount = compute.weekdayDiscountCompute(result)
            totalDiscount += discount
        }
        return discount
    }

    fun weekendDiscount(): Int {
        var discount = 0
        if (day.isWeekend()) {
            discount = compute.weekendDiscountCompute(result)
            totalDiscount += discount
        }
        return discount
    }

    fun specialDiscount(): Int {
        var discount = 0
        if (day.isSpecialDay()) {
            discount = -1000
            totalDiscount += discount
        }
        return discount
    }

    fun presentationDiscount(): Int {
        var discount = 0
        if (isTotalPriceOver120000()) {
            discount = -25000
            totalDiscount += discount
        }
        return discount
    }

    fun isTotalPriceOver120000(): Boolean {
        return getTotalPrice() >= 120000
    }

    fun getTotalDiscount(): Int {
        return totalDiscount
    }

    fun getTotalPrice(): Int {
        return result.entries.sumOf { Menu.ofPrice(it.key) * it.value }
    }

    fun getFinalPayment() : Int{
        return compute.finalPaymentCompute(getTotalPrice(),getTotalDiscount())
    }

}