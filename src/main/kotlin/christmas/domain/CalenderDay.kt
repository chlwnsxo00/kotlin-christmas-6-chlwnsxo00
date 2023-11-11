package christmas.domain

class CalenderDay(private val date: Int) {
    private val isWeekend = getDayOfTheWeekend()
    private fun getDayOfTheWeekend(): Boolean {
        if (date % 7 == 1 || date % 7 == 2) {
            return true
        }
        return false
    }

    fun isWeekend(): Boolean {
        return isWeekend
    }
}