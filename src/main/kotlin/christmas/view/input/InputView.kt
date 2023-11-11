package christmas.view.input

import camp.nextstep.edu.missionutils.Console
import christmas.constants.askOrderMenuMessage
import christmas.constants.askVisitDateMessage
import christmas.constants.introMessage
import christmas.view.output.OutputView

class InputView {
    val output = OutputView()
    fun askVisitDate():String{
        output.printAskVisitDateMessage()
        return Console.readLine()
    }

    fun askOrderMenu():String{
        output.printAskOrderMenuMessage()
        return Console.readLine()
    }
}