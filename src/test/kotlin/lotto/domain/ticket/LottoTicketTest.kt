package lotto.domain.ticket

import lotto.domain.ticket.number.LottoNumber
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class LottoTicketTest {

    @DisplayName("로또 한 장은 6개의 로또숫자로 이루어지고, 그렇지 않으면 예외가 발생한다.")
    @Test
    fun create1() {
        // given
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(2)
        val lottoNumber3 = LottoNumber.of(3)
        val lottoNumber4 = LottoNumber.of(4)
        val lottoNumber5 = LottoNumber.of(5)

        val lottoNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5)

        // when // then
        assertFailsWith<IllegalArgumentException>(
            block = {
                LottoTicket(lottoNumbers)
            }
        )
    }

    @DisplayName("로또 한 장을 이루는 6개의 로또 숫자는 중복이 없어야 한다.")
    @Test
    fun create2() {
        // given
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(1)
        val lottoNumber3 = LottoNumber.of(3)
        val lottoNumber4 = LottoNumber.of(4)
        val lottoNumber5 = LottoNumber.of(5)
        val lottoNumber6 = LottoNumber.of(6)

        val lottoNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6)

        // when // then
        assertFailsWith<IllegalArgumentException>(
            block = {
                LottoTicket(lottoNumbers)
            }
        )
    }

    @DisplayName("로또 티켓의 숫자는 오름차순으로 정렬하여 관리된다.")
    @Test
    fun sorted() {
        // given
        val lottoNumber1 = LottoNumber.of(6)
        val lottoNumber2 = LottoNumber.of(5)
        val lottoNumber3 = LottoNumber.of(4)
        val lottoNumber4 = LottoNumber.of(3)
        val lottoNumber5 = LottoNumber.of(2)
        val lottoNumber6 = LottoNumber.of(1)

        val lottoNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6)

        // when
        val lottoTicket = LottoTicket(lottoNumbers)

        // then
        assertEquals(
            lottoTicket.numbers,
            listOf(lottoNumber6, lottoNumber5, lottoNumber4, lottoNumber3, lottoNumber2, lottoNumber1)
        )
    }

    @DisplayName("로또 숫자가 티켓에 포함되어있는지를 확인한다.")
    @Test
    fun contains() {
        // given
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(2)
        val lottoNumber3 = LottoNumber.of(3)
        val lottoNumber4 = LottoNumber.of(4)
        val lottoNumber5 = LottoNumber.of(5)
        val lottoNumber6 = LottoNumber.of(6)
        val lottoNumber7 = LottoNumber.of(7)

        val lottoNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6)
        val lottoTicket = LottoTicket(lottoNumbers)

        // when
        val result1 = lottoTicket.contains(lottoNumber1)
        val result2 = lottoTicket.contains(lottoNumber7)

        // then
        assertEquals(result1, true)
        assertEquals(result2, false)
    }

}
