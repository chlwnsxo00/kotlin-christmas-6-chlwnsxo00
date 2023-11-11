package christmas.view.input

import camp.nextstep.edu.missionutils.Console
import christmas.domain.CalenderValidate
import christmas.view.output.OutputView

class InputView {
    private val output = OutputView()
    private val validate = CalenderValidate()
    fun askVisitDate(): Int {
        return try {
            output.printAskVisitDateMessage()
            return validate.validateVisitDate(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            askVisitDate()
        }
    }

    fun askOrderMenu(): Map<String, Int> {
        return try{
            output.printAskOrderMenuMessage()
            return validate.validateOrderedMenu(Console.readLine())
        }catch (e:IllegalArgumentException){
            println(e.message)
            askOrderMenu()
        }
    }
}