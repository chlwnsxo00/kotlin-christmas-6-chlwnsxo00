package christmas.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalenderDiscountTest {
    @Test
    fun `christmasDDayDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val day = CalenderDay(11)
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(day, menu)
        val result = -2000

        //when
        discount.christmasDDayDiscount()

        //then
        assertThat(discount).extracting("totalDiscount").isEqualTo(result)
    }

    @Test
    fun `weekdayDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val day = CalenderDay(11)
        val menu = mutableMapOf(Pair("초코케이크", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(day, menu)
        val result = -4046

        //when
        discount.weekdayDiscount()

        //then
        assertThat(discount).extracting("totalDiscount").isEqualTo(result)
    }

    @Test
    fun `weekendDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val day = CalenderDay(1)
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(day, menu)
        val result = -2023

        //when
        discount.weekendDiscount()

        //then
        assertThat(discount).extracting("totalDiscount").isEqualTo(result)
    }

    @Test
    fun `specialDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val day = CalenderDay(25)
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(day, menu)
        val result = -1000

        //when
        discount.specialDiscount()

        //then
        assertThat(discount).extracting("totalDiscount").isEqualTo(result)
    }

    @Test
    fun `presentationDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val day = CalenderDay(1)
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 10))
        val discount = CalenderDiscount(day, menu)
        val result = -25000

        //when
        discount.presentationDiscount()

        //then
        assertThat(discount).extracting("totalDiscount").isEqualTo(result)
    }
}