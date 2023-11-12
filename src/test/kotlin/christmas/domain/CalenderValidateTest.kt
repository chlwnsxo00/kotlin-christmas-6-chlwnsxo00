package christmas.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalenderValidateTest {
    val validate = CalenderValidate()

    @Test
    fun `validateVisitDate 메소드 사용시 식당 예상 방문 날짜 입력 조건에 맞는지 확인 후 아닐시 오류 발생`() {
        assertSimpleTest {
            // 1 ~ 31 사이의 숫자가 아니라면, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("0")
            }
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("32")
            }
            // 입력이 문자라면, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("asdf")
            }
            // 입력이 공백이라면, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("")
            }
        }
    }

    @Test
    fun `validateOrderedMenu 메소드 사용시 메뉴 입력의 양식에 맞는지 확인 후 아닐시 오류 발생`() {
        assertSimpleTest {
            // 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("타파스-11,제로콜라-12")
            }
            // 음료만 주문 시, 주문할 수 없습니다.
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("샴페인-1,제로콜라-1")
            }
            // 중복 메뉴 입력시, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("타파스-5,제로콜라-1,타파스-5")
            }
            // 메뉴판에 없는 메뉴 입력시, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("짜장면-3,제로콜라-1,타파스-5")
            }
            // 메뉴 입력의 양식을 지키지 않은 경우, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("제로콜라--1,타파스-5")
            }
            // 메뉴 개수가 숫자가 아닐 떄, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("제로콜라-as,타파스-5")
            }
            // 메뉴 개수가 1 이상의 숫자가 아닐 때, IllegalArgumentException 발생
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate("타파스-0")
            }
        }
    }

    @Test
    fun `validateVisitDate 메소드 사용시 정상작동 확인`() {
        assertThat(validate.validateVisitDate("10"))
            .isEqualTo(
                10
            )
    }

    @Test
    fun `validateOrderedMenu 메소드 사용시 정상작동 확인`() {
        assertThat(validate.validateOrderedMenu("티본스테이크-1,바비큐립-1,제로콜라-1,초코케이크-2"))
            .isEqualTo(
                mutableMapOf(
                    Pair("티본스테이크", 1),
                    Pair("바비큐립", 1),
                    Pair("초코케이크", 2),
                    Pair("제로콜라", 1)
                )
            )
    }
}