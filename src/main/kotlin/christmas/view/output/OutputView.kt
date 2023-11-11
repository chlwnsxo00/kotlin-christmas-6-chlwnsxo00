package christmas.view.output

import christmas.constants.askOrderMenuMessage
import christmas.constants.askVisitDateMessage
import christmas.constants.introMessage

class OutputView {
    fun printAskVisitDateMessage(){
        println(introMessage)
        println(askVisitDateMessage)
    }

    fun printAskOrderMenuMessage(){
        println(askOrderMenuMessage)
    }
}