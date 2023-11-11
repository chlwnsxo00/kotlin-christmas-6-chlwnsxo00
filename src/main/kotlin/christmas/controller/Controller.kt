package christmas.controller

import christmas.domain.CalenderValidate
import christmas.view.input.InputView

class Controller {
    private val input = InputView()
    private val validate = CalenderValidate()
    fun run(){
        val visitDate = validate.validateVisitDate(input.askVisitDate())
        val menuOrder = validate.validateOrderedMenu(input.askOrderMenu())

    }
}