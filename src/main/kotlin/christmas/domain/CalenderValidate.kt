package christmas.domain

import christmas.constants.drink
import christmas.constants.isInvalidDateError
import christmas.constants.isInvalidOrderError
import christmas.constants.isOrderedOnlyDrinkError
import christmas.constants.isTotalNumberOfMenusOver20Error


class CalenderValidate {
    fun validateVisitDate(input: String): Int {
        isCharacter(input)
        isBlank(input)
        isInRange(input)
        return input.toInt()
    }

    fun validateOrderedMenu(input: String): Map<String, Int> {
        val result = mutableMapOf<String, Int>()
        isBlank(input)
        val menuSet = input.split(",")
        for (menu in menuSet) {
            val pair = menu.split("-")
            checkPairSize(pair.size)
            val menuName = pair[0]
            validateMenuName(menuName, result)
            val menuAmount = pair[1]
            validateMenuAmount(menuAmount)
            result[menuName] = menuAmount.toInt()
        }
        validateResult(result)
        return result
    }

    private fun validateResult(result: MutableMap<String, Int>) {
        isTotalNumberOfMenusOver20Error(result)
        isOrderedOnlyDrink(result)
    }

    private fun isOrderedOnlyDrink(result: MutableMap<String, Int>) {
        for (menu in result) {
            if (Menu.ofType(menu.key) == drink) {
                result.remove(menu.key)
            }
        }
        if (result.isEmpty())
            throw IllegalArgumentException(isOrderedOnlyDrinkError)
    }

    private fun isTotalNumberOfMenusOver20Error(result: MutableMap<String, Int>) {
        val totalMenuAmount = result.values.sum()
        if (totalMenuAmount > 20)
            throw IllegalArgumentException(isTotalNumberOfMenusOver20Error)
    }

    private fun validateMenuName(input: String, result: Map<String, Int>) {
        Menu.checkExistMenu(input)
        isDuplicateMenu(input, result)
    }

    private fun isDuplicateMenu(input: String, result: Map<String, Int>) {
        if (result.containsKey(input))
            throw IllegalArgumentException(isInvalidOrderError)
    }

    private fun isPositive(input: String) {
        if (input.toInt() < 1)
            throw IllegalArgumentException(isInvalidOrderError)
    }

    private fun validateMenuAmount(input: String) {
        isCharacter(input)
        isBlank(input)
        isPositive(input)
    }

    private fun checkPairSize(size: Int) {
        if (size != 2)
            throw IllegalArgumentException(isInvalidOrderError)
    }

    private fun isBlank(input: String) {
        if (input.isBlank())
            throw IllegalArgumentException(isInvalidDateError)
    }

    private fun isInRange(input: String) {
        if (input.toInt() !in 1..31)
            throw IllegalArgumentException(isInvalidDateError)
    }

    private fun isCharacter(input: String) {
        if (input.toIntOrNull() == null)
            throw IllegalArgumentException(isInvalidDateError)
    }

}