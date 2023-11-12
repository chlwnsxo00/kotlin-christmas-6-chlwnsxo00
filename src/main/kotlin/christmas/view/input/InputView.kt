package christmas.view.input

import camp.nextstep.edu.missionutils.Console
import christmas.constants.askVisitDateMessage
import christmas.domain.CalenderValidate
import christmas.view.output.OutputView

class InputView {
    private val output = OutputView()
    private val validate = CalenderValidate()
    fun askVisitDate(input: String): Int {
        return try {
            return validate.validateVisitDate(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            output.printAskVisitDateMessage()
            askVisitDate(Console.readLine())
        }
    }

    fun askOrderMenu(input: String): Map<String, Int> {
        return try {
            return validate.validateOrderedMenu(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            output.printAskOrderMenuMessage()
            askOrderMenu(Console.readLine())
        }
    }
}