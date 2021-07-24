package lotto.domain.number

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class LottoNumberTest {

    @DisplayName("로또 숫자는 0 이상의 정수다.")
    @Test
    internal fun create() {
        // given
        val number = 0

        // when // then
        assertFailsWith<IllegalArgumentException>(
            message = "No exception found",
            block = {
                LottoNumber(number)
            }
        )
    }

    @DisplayName("로또 숫자는 45 이하의 정수다.")
    @Test
    internal fun create2() {
        // given
        val number = 46

        // when // then
        assertFailsWith<IllegalArgumentException>(
            message = "No exception found",
            block = {
                LottoNumber(number)
            }
        )
    }

    @DisplayName("로또 숫자는 VO로, 같은 숫자를 가진 인스턴스는 모두 동등하다.")
    @Test
    internal fun equalsAndHashCode() {
        // given
        val lottoNumber1 = LottoNumber(1)
        val lottoNumber2 = LottoNumber(1)

        // when // then
        assertEquals(lottoNumber1, lottoNumber2)
    }

}
