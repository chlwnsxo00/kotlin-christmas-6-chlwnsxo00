package christmas.view.input

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import christmas.constants.isInvalidDateError
import christmas.constants.isInvalidOrderError
import christmas.constants.isOrderedOnlyDrinkError
import christmas.constants.isTotalNumberOfMenusOver20Error
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class InputViewTest : NsTest() {

    @Test
    fun `askVisitDate 메소드 사용시 식당 예상 방문 날짜 입력 조건에 맞는지 확인 후 아닐시 오류 발생`() {
        assertSimpleTest {
            // 1 ~ 31 사이의 숫자가 아니라면, IllegalArgumentException 발생
            runException("askVisitDate","0")
            assertThat(output()).contains(isInvalidDateError)

            runException("askVisitDate","32")
            assertThat(output()).contains(isInvalidDateError)

            // 입력이 문자라면, IllegalArgumentException 발생
            runException("askVisitDate","as")
            assertThat(output()).contains(isInvalidDateError)

            // 입력이 공백이라면, IllegalArgumentException 발생
            runException("askVisitDate","")
            assertThat(output()).contains(isInvalidDateError)

            // 입력이 공백이라면, IllegalArgumentException 발생
            runException("askVisitDate","")
            assertThat(output()).contains(isInvalidDateError)
        }
    }

    @Test
    fun `askOrderMenu 메소드 사용시 식당 예상 방문 날짜 입력 조건에 맞는지 확인 후 아닐시 오류 발생`() {
        assertSimpleTest {
            // 메뉴 입력의 양식을 지키지 않은 경우, IllegalArgumentException 발생
            runException("askOrderMenu","티본스테이크--2,바비큐립-1")
            assertThat(output()).contains(isInvalidOrderError)

            // 중복 메뉴 입력시, IllegalArgumentException 발생
            runException("askOrderMenu","티본스테이크-2,바비큐립-1,티본스테이크-2")
            assertThat(output()).contains(isInvalidOrderError)

            // 메뉴 개수가 숫자가 아닐 떄, IllegalArgumentException 발생
            runException("askOrderMenu","티본스테이크-2,바비큐립-ab")
            assertThat(output()).contains(isInvalidOrderError)

            // 메뉴 개수가 1 이상의 숫자가 아닐 때, IllegalArgumentException 발생
            runException("askOrderMenu","티본스테이크-2,바비큐립-0")
            assertThat(output()).contains(isInvalidOrderError)

            // 메뉴판에 없는 메뉴 입력시, IllegalArgumentException 발생
            runException("askOrderMenu","짜장면-2,바비큐립-1")
            assertThat(output()).contains(isInvalidOrderError)

            // 음료만 주문 시, 주문하면, IllegalArgumentException 발생
            runException("askOrderMenu","제로콜라-2,샴페인-1")
            assertThat(output()).contains(isOrderedOnlyDrinkError)

            // 메뉴는 한 번에 최대 20개까지만 주문했다면, IllegalArgumentException 발생
            runException("askOrderMenu","티본스테이크-12,바비큐립-11")
            assertThat(output()).contains(isTotalNumberOfMenusOver20Error)
        }
    }
    override fun runMain() {
        val input = InputView()
        val test = Console.readLine()
        if(test=="askVisitDate")
            input.askVisitDate(Console.readLine())
        else if(test=="askOrderMenu")
            input.askOrderMenu(Console.readLine())
    }
}