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

    @Test
    fun `isWeekend 메소드 사용시 3일을 입력시 일요일이므로 false를 출력`() {
        //given
        val input = 3
        val result = false

        //when
        val day = CalenderDay(input)

        //then
        Assertions.assertThat(day.isWeekend()).isEqualTo(result)
    }
    @Test
    fun ` isSpecialDay 메소드 사용시 25일을 입력시 special day이므로 true 출력`() {
        //given
        val input = 25
        val result = true

        //when
        val day = CalenderDay(input)

        //then
        Assertions.assertThat(day.isSpecialDay()).isEqualTo(result)
    }

    @Test
    fun `isSpecialDay 메소드 사용시 3일을 입력시 special day이므로 true 출력`() {
        //given
        val input = 3
        val result = true

        //when
        val day = CalenderDay(input)

        //then
        Assertions.assertThat(day.isSpecialDay()).isEqualTo(result)
    }
}