package christmas.domain

class CalenderDay(private val date: Int) {
    fun isWeekend(): Boolean {
        if (date % 7 == 1 || date % 7 == 2) {
            return true
        }
        return false
    }

    fun isSpecialDay(): Boolean {
        if (date % 7 == 3 || date == 25)
            return true
        return false
    }
}