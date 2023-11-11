package christmas.controller

import christmas.domain.CalenderDay
import christmas.view.input.InputView
import christmas.view.output.OutputView

class Controller {
    private val input = InputView()
    private val output = OutputView()
    fun run() {
        val visitDate = input.askVisitDate()
        val menuOrder = input.askOrderMenu()
        val day = CalenderDay(visitDate)
        output.printPreviewEventBenefits(day,menuOrder)
    }
}