package christmas.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CalenderResultTest {
    @Test
    fun `christmasDDayResult 메소드 사용시 할인 가능 여부 확인 후 totalDiscount에 축적`() {
        //given
        val date = 11
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val calenderResult = CalenderResult(date, menu)
        val result = -2000

        //when
        calenderResult.christmasDDayResult()

        //then
        Assertions.assertThat(calenderResult.getTotalDiscount()).isEqualTo(result)
    }

    @Test
    fun `weekdayResult 메소드 사용시 할인 가능 여부 확인 후 totalDiscount에 축적`() {
        //given
        val date = 11
        val menu = mutableMapOf(Pair("아이스크림", 2), Pair("티본스테이크", 1))
        val result = -4046
        val calenderResult = CalenderResult(date, menu)

        //when
        calenderResult.weekdayResult()

        //then
        Assertions.assertThat(calenderResult.getTotalDiscount()).isEqualTo(result)
    }

    @Test
    fun `weekendResult 메소드 사용시 할인 가능 여부 확인 후 totalDiscount에 축적`() {
        //given
        val date = 1
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val result = -2023
        val calenderResult = CalenderResult(date, menu)

        //when
        calenderResult.weekendResult()

        //then
        Assertions.assertThat(calenderResult.getTotalDiscount()).isEqualTo(result)
    }

    @Test
    fun `specialResult 메소드 사용시 할인 가능 여부 확인 후 totalDiscount에 축적`() {
        //given
        val date = 25
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 1))
        val result = -1000
        val calenderResult = CalenderResult(date, menu)

        //when
        calenderResult.specialResult()

        //then
        Assertions.assertThat(calenderResult.getTotalDiscount()).isEqualTo(result)
    }

    @Test
    fun `presentationResult 메소드 사용시 할인 가능 여부 확인 후 totalDiscount에 축적`() {
        //given
        val date = 1
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 10))
        val result = -Menu.ofPrice("샴페인")
        val calenderResult = CalenderResult(date, menu)

        //when
        calenderResult.presentationResult()

        //then
        Assertions.assertThat(calenderResult.getTotalDiscount()).isEqualTo(result)
    }

    @Test
    fun `isTotalPriceOver120000 메소드 사용시 totalPrice가 120000 이상인지 Bool 반환`() {
        //given
        val date = 1
        val menu = mutableMapOf(Pair("타파스", 2), Pair("티본스테이크", 10))
        val result = true
        val calenderResult = CalenderResult(date, menu)

        //then
        Assertions.assertThat(
            calenderResult.isTotalPriceOver120000()
        ).isEqualTo(result)
    }

    @Test
    fun `getTotalDiscount 메소드 사용시 증정 가격을 포함한 총 할인 가격을 반환`() {
        //given
        val date = 3
        val menu =
            mutableMapOf(
                Pair("초코케이크", 2),
                Pair("티본스테이크", 1),
                Pair("바비큐립", 1),
                Pair("제로콜라", 1)
            )
        val result = -31246
        val calenderResult = CalenderResult(date, menu)

        //when
        calenderResult.christmasDDayResult()
        calenderResult.weekdayResult()
        calenderResult.weekendResult()
        calenderResult.specialResult()
        calenderResult.presentationResult()

        //then
        Assertions.assertThat(
            calenderResult.getTotalDiscount()
        ).isEqualTo(result)
    }

    @Test
    fun `getTotalPrice 메소드 사용시 할인 전 총 가격을 반환`() {
        //given
        val date = 3
        val menu =
            mutableMapOf(
                Pair("초코케이크", 2),
                Pair("티본스테이크", 1),
                Pair("바비큐립", 1),
                Pair("제로콜라", 1)
            )
        val result = 142000
        val calenderResult = CalenderResult(date, menu)

        //then
        Assertions.assertThat(
            calenderResult.getTotalPrice()
        ).isEqualTo(result)
    }

    @Test
    fun `getFinalPayment 메소드 사용시 총 가격에서 증정품의 가격을 포함하지 않은 할인 금액을 제외한 가격을 반환`() {
        //given
        val date = 3
        val menu =
            mutableMapOf(
                Pair("초코케이크", 2),
                Pair("티본스테이크", 1),
                Pair("바비큐립", 1),
                Pair("제로콜라", 1)
            )
        val result = 135754
        val calenderResult = CalenderResult(date, menu)

        //when
        calenderResult.christmasDDayResult()
        calenderResult.weekdayResult()
        calenderResult.weekendResult()
        calenderResult.specialResult()
        calenderResult.presentationResult()

        //then
        Assertions.assertThat(
            calenderResult.getFinalPayment()
        ).isEqualTo(result)
    }
}