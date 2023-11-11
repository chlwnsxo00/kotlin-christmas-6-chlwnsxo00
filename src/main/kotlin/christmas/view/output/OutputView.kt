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
        else
            println(noneDiscountMessage)
    }

    fun printWeekdayDiscountResult(discount:Int){
        if(discount!=0)
            println(weekdayDiscountMessage + priceMessage(discount))
        else
            println(noneDiscountMessage)
    }

    fun printWeekendDiscountResult(discount: Int) {
        if(discount!=0)
            println(weekendDiscountMessage + priceMessage(discount))
        else
            println(noneDiscountMessage)
    }

    fun printSpecialDiscountResult(discount: Int) {
        if(discount!=0)
            println(specialDiscountMessage + priceMessage(discount))
        else
            println(noneDiscountMessage)
    }

    fun presentationDiscount(discount: Int) {
        if(discount!=0)
            println(presentationDiscountMessage + priceMessage(discount))
        else
            println(noneDiscountMessage)
    }
}