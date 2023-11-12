package christmas.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalenderDiscountTest {
    @Test
    fun `christmasDDayDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val date = 11
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(date, menu)
        val result = -2000

        //then
        assertThat(discount.christmasDDayDiscount()).isEqualTo(result)
    }

    @Test
    fun `weekdayDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val date = 11
        val menu = mutableMapOf(Pair("초코케이크", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(date, menu)
        val result = -4046

        //then
        assertThat(discount.weekdayDiscount()).isEqualTo(result)
    }

    @Test
    fun `weekendDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val date = 1
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(date, menu)
        val result = -2023

        //then
        assertThat(discount.weekendDiscount()).isEqualTo(result)
    }

    @Test
    fun `specialDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val date = 25
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val discount = CalenderDiscount(date, menu)
        val result = -1000

        //then
        assertThat(discount.specialDiscount()).isEqualTo(result)
    }

    @Test
    fun `presentationDiscount 메소드 사용시 할인 적용 및 출력`() {
        //given
        val date = 1
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 10))
        val discount = CalenderDiscount(date, menu)
        val result = -25000

        //then
        assertThat(discount.presentationDiscount()).isEqualTo(result)
    }
}