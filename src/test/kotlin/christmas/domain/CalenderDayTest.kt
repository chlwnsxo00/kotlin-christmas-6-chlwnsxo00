package christmas.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CalenderDayTest {
    @Test
    fun `isWeekend 메소드 사용시 1일을 입력시 금요일이므로 true를 출력`() {
        //given
        val input = 1
        val result = true

        //when
        val day = CalenderDay(input)

        //then
        Assertions.assertThat(day.isWeekend()).isEqualTo(result)
    }
}