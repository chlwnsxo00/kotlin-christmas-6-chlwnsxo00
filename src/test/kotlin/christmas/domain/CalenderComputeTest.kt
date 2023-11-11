package christmas.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalenderComputeTest {
    @Test
    fun `christmasDDayDiscountCompute 메소드 사용시 11일 입력시 -2000 반환`() {
        //given
        val compute = CalenderCompute()
        val input = 11
        val result = -2000

        //then
        assertThat(compute.christmasDDayDiscountCompute(input)).isEqualTo(result)
    }
    @Test
    fun `weekdayDiscountCompute 메소드 사용시 1일을 입력시 금요일이므로 true를 출력`() {
        //given
        val compute = CalenderCompute()
        val input = mutableMapOf<String,Int>(Pair("타파스",2),Pair("티본스테이크",1))
        val result = -4046

        //then
        assertThat(compute.weekdayDiscountCompute(input)).isEqualTo(result)
    }
    @Test
    fun `weekendDiscountCompute 메소드 사용시 1일을 입력시 금요일이므로 true를 출력`() {
        //given
        val compute = CalenderCompute()
        val input = mutableMapOf<String,Int>(Pair("타파스",2),Pair("티본스테이크",1))
        val result = -2023

        //then
        assertThat(compute.weekendDiscountCompute(input)).isEqualTo(result)
    }
}