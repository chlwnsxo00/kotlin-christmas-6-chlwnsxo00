package christmas.view.output

import christmas.constants.askOrderMenuMessage
import christmas.constants.askVisitDateMessage
import christmas.constants.christmasDDayDiscountMessage
import christmas.constants.introMessage
import christmas.constants.presentationDiscountMessage
import christmas.constants.specialDiscountMessage
import christmas.constants.weekdayDiscountMessage
import christmas.constants.weekendDiscountMessage
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
    private fun priceMessage(prize: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale("en", "US"))
        return priceMessage.format(formatter.format(prize))
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
        println(specialDiscountMessage + priceMessage(discount))
    }

    fun presentationDiscount(discount: Int) {
        println(presentationDiscountMessage + priceMessage(discount))
    }
}