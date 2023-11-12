package christmas.view.output

import camp.nextstep.edu.missionutils.test.NsTest
import christmas.domain.CalenderDay
import christmas.domain.CalenderDiscount
import christmas.domain.CalenderResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {
    private val out = OutputView()

    @Test
    fun `printIntroPreviewEventBenefits 메소드 사용시 출력 확인`() {
        //given
        val date = 10

        //when
        out.printIntroPreviewEventBenefits(date)

        //then
        assertThat(output()).contains(
            "12월 10일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
        )

    }

    @Test
    fun `printOrderedMenu 메소드 사용시 출력 확인`() {
        //given
        val input = mutableMapOf(
            Pair("티본스테이크", 1),
            Pair("바비큐립", 1),
            Pair("초코케이크", 2),
            Pair("제로콜라", 1)
        )

        //when
        out.printOrderedMenu(input)

        //then
        assertThat(output()).contains(
            "<주문 메뉴>",
            "티본스테이크 1개",
            "바비큐립 1개",
            "초코케이크 2개",
            "제로콜라 1개"
        )
    }

    @Test
    fun `printTotalPriceBeforeDiscount 메소드 사용시 출력 확인`() {
        //given
        val input = 150000

        //when
        out.printTotalPriceBeforeDiscount(input)

        //then
        assertThat(output()).contains(
            "<할인 전 총주문 금액>",
            "150,000원"
        )
    }

    @Test
    fun `printPresentationMenu 메소드 사용시 출력 확인`() {
        //given
        val grantee = true

        //when
        out.printPresentationMenu(grantee)

        //then
        assertThat(output()).contains(
            "<증정 메뉴>",
            "샴페인 1개"
        )
    }

    @Test
    fun `printDiscountLog 메소드 사용시 출력 확인`() {
        //given
        val orderMenu = mutableMapOf(
            Pair("티본스테이크", 1),
            Pair("바비큐립", 1),
            Pair("초코케이크", 2),
            Pair("제로콜라", 1)
        )
        val date = 3

        //when
        out.printDiscountLog(CalenderResult(date, orderMenu))

        //then
        assertThat(output()).contains(
            "<혜택 내역>",
            "크리스마스 디데이 할인: -1,200원",
            "평일 할인: -4,046원",
            "특별 할인: -1,000원",
            "증정 이벤트: -25,000원"
        )
    }

    @Test
    fun `printTotalDiscount 메소드 사용시 출력 확인`() {
        //given
        val input = 120000

        //when
        out.printTotalDiscount(input)

        //then
        assertThat(output()).contains(
            "<총혜택 금액>",
            "120,000원"
        )
    }

    @Test
    fun `printFinalPayment 메소드 사용시 출력 확인`() {
        //given
        val input = 120000

        //when
        out.printFinalPayment(input)

        //then
        assertThat(output()).contains(
            "<할인 후 예상 결제 금액>",
            "120,000원"
        )
    }

    @Test
    fun `printEventBadge 메소드 사용시 출력 확인`() {
        //given
        val input = -50000

        //when
        out.printEventBadge(input)

        //then
        assertThat(output()).contains(
            "<12월 이벤트 배지>",
            "산타"
        )
    }

    override fun runMain() {
    }

}