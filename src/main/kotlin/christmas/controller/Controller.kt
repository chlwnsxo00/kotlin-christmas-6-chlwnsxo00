package christmas.controller

import camp.nextstep.edu.missionutils.Console
import christmas.domain.CalenderCompute
import christmas.domain.CalenderDay
import christmas.domain.CalenderDiscount
import christmas.domain.CalenderResult
import christmas.view.input.InputView
import christmas.view.output.OutputView

class Controller {
    private val input = InputView()
    private val output = OutputView()
    fun run() {
        output.printAskVisitDateMessageWithIntro()
        val visitDate = input.askVisitDate(Console.readLine())
        output.printAskOrderMenuMessage()
        val menuOrder = input.askOrderMenu(Console.readLine())
        val result = CalenderResult(visitDate, menuOrder)
        output.printIntroPreviewEventBenefits(visitDate)
        output.printOrderedMenu(menuOrder)
        output.printEventResult(result)
    }
}