package christmas.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalenderValidateTest {
    val validate = CalenderValidate()

    @ValueSource(strings = ["0", "32", "asdf", ""])
    @ParameterizedTest
    fun `validateVisitDate 메소드 사용시 식당 예상 방문 날짜 입력 조건에 맞는지 확인 후 아닐시 오류 발생`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate(input)
            }
        }
    }

    @ValueSource(
        strings = ["타파스-11,제로콜라-12",
            "샴페인-1,제로콜라-1",
            "타파스-5,제로콜라-1,타파스-5",
            "짜장면-3,제로콜라-1,타파스-5",
            "제로콜라--1,타파스-5",
            "제로콜라-as,타파스-5",
            "타파스-0"]
    )
    @ParameterizedTest
    fun `validateOrderedMenu 메소드 사용시 메뉴 입력의 양식에 맞는지 확인 후 아닐시 오류 발생`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validate.validateVisitDate(input)
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