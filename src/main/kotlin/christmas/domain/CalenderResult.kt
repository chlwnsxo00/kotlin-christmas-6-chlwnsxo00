package christmas.domain

class CalenderResult(private val date: Int, private val result: Map<String, Int>) {

    private val discount = CalenderDiscount(date,result)
    private var totalDiscount = 0
    fun christmasDDayResult() :Int{
        totalDiscount += discount.christmasDDayDiscount()
        return discount.christmasDDayDiscount()
    }

    fun weekdayResult() :Int{
        totalDiscount += discount.weekdayDiscount()
        return discount.weekdayDiscount()
    }

    fun weekendResult(): Int {
        totalDiscount += discount.weekendDiscount()
        return discount.weekendDiscount()
    }

    fun specialResult(): Int {
        totalDiscount += discount.specialDiscount()
        return discount.specialDiscount()
    }

    fun presentationResult(): Int {
        totalDiscount += discount.presentationDiscount()
        return discount.presentationDiscount()
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
        if (isTotalPriceOver120000())
            return (getTotalPrice() + totalDiscount + Menu.ofPrice("샴페인"))
        return (getTotalPrice() + totalDiscount)
    }
}