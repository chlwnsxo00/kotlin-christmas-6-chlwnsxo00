package christmas.view.output

import christmas.constants.askOrderMenuMessage
import christmas.constants.askVisitDateMessage
import christmas.constants.christmasDDayDiscountMessage
import christmas.constants.introMessage
import christmas.constants.noneDiscountMessage
import christmas.constants.presentationDiscountMessage
import christmas.constants.specialDiscountMessage
import christmas.constants.weekdayDiscountMessage
import christmas.constants.weekendDiscountMessage
import christmas.domain.CalenderCompute
import christmas.domain.CalenderDay
import christmas.domain.CalenderDiscount
import java.awt.SystemColor.menu
import java.text.NumberFormat
import java.util.Locale

class OutputView {
    private val priceMessage = "%s원"
    fun printAskVisitDateMessage(){
        println(introMessage)
        println(askVisitDateMessage)
    }

    fun printAskOrderMenuMessage(){
        println(askOrderMenuMessage)
    }
    private fun priceMessage(price: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale("en", "US"))
        return priceMessage.format(formatter.format(price))
    }

    fun printChristmasDDayDiscountResult(discount:Int){
        if(discount!=0)
            println(christmasDDayDiscountMessage + priceMessage(discount))
    }

    fun printWeekdayDiscountResult(discount:Int){
        if(discount!=0)
            println(weekdayDiscountMessage + priceMessage(discount))
    }

    fun printWeekendDiscountResult(discount: Int) {
        if(discount!=0)
            println(weekendDiscountMessage + priceMessage(discount))
    }

    fun printSpecialDiscountResult(discount: Int) {
        if(discount!=0)
            println(specialDiscountMessage + priceMessage(discount))
    }

    fun presentationDiscount(discount: Int) {
        if(discount!=0)
            println(presentationDiscountMessage + priceMessage(discount))
    }

    fun printPreviewEventBenefits(day: CalenderDay,result: Map<String, Int>){
        println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()
        printOrderedMenu(result)
        val discount = CalenderDiscount(day,result)
        printTotalPriceBeforeDiscount(discount.getTotalPrice())
        printPresentationMenu(discount.isTotalPriceOver120000())
        printDiscountLog(discount)
        printTotalDiscount(discount)
        printFinalPayment(discount.getTotalPrice()+discount.getTotalDiscount())
        printEventBadge(discount.getTotalDiscount())
    }


    fun printOrderedMenu(result : Map<String,Int>){
        println("<주문 메뉴>")
        for (menu in result){
            println("${menu.key} ${menu.value}개")
        }
        println()
    }

    fun printTotalPriceBeforeDiscount(total : Int){
        println("<할인 전 총주문 금액>")
        println(priceMessage(total))
        println()
    }

    fun printPresentationMenu(bool : Boolean){
        println("<증정 메뉴>")
        if(bool)
            println("샴페인 1개")
        else
            println(noneDiscountMessage)
        println()
    }

    fun printDiscountLog(discount: CalenderDiscount){
        println("<혜택 내역>")
        discount.christmasDDayDiscount()
        discount.weekdayDiscount()
        discount.weekendDiscount()
        discount.specialDiscount()
        discount.presentationDiscount()
        if(discount.getTotalDiscount()==0)
            println(noneDiscountMessage)
        println()
    }

    fun printTotalDiscount(discount: CalenderDiscount){
        println("<총혜택 금액>")
        println(priceMessage(discount.getTotalDiscount()))
        println()
    }

    fun printFinalPayment(finalPayment:Int){
        println("<할인 후 예상 결제 금액>")
        println(priceMessage(finalPayment))
        println()
    }

    fun printEventBadge(totalDiscount:Int){
        val compute=CalenderCompute()
        println("<12월 이벤트 배지>")
        println(compute.decideBadge(totalDiscount))
    }
}