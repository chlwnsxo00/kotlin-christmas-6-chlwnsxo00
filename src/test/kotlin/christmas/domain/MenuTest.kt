package christmas.domain

import christmas.constants.drink
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class MenuTest {
    @Test
    fun `ofType 메소드 사용시 메뉴 이름을 입력하면 해당 메뉴가 있는지 확인후 메뉴 타입을 반환`() {
        //given
        val input = "제로콜라"
        val result = drink

        //then
        assertThat(Menu.ofType(input)).isEqualTo(result)
    }
    @Test
    fun `ofPrice 메소드 사용시 메뉴 이름을 입력하면 해당 메뉴가 있는지 확인후 메뉴 가격을 반환`() {
        //given
        val input = "제로콜라"
        val result = 3000

        //then
        assertThat(Menu.ofPrice(input)).isEqualTo(result)
    }
}