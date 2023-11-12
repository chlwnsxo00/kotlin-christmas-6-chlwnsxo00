package christmas.domain

import camp.nextstep.edu.missionutils.test.Assertions
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
        val input = mutableMapOf(Pair("초코케이크",2),Pair("티본스테이크",1))
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

    @Test
    fun `decideBadge 메소드 사용시 가격에 따라 산타, 트리, 별, 없음 출력`() {
        //given
        val compute = CalenderCompute()

        //then
        Assertions.assertSimpleTest {
            assertThat(compute.decideBadge(-20000)).isEqualTo("산타")
            assertThat(compute.decideBadge(-10000)).isEqualTo("트리")
            assertThat(compute.decideBadge(-5000)).isEqualTo("별")
            assertThat(compute.decideBadge(-1000)).isEqualTo("없음")
        }
    }
}