package lotto.domain.ticket.winning

import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.number.LottoNumber
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class WinningLottoTest {

    @DisplayName("보너스 볼이 당첨 번호에 포함되는 숫자면 예외가 발생한다.")
    @Test
    fun containsBonusBall() {
        // given
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(2)
        val lottoNumber3 = LottoNumber.of(3)
        val lottoNumber4 = LottoNumber.of(4)
        val lottoNumber5 = LottoNumber.of(5)

        val bonusBall = LottoNumber.of(6)

        val lottoNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, bonusBall)
        val lottoTicket = LottoTicket(lottoNumbers)

        // when // then
        assertFailsWith<IllegalArgumentException>(
            block = {
                WinningLotto(lottoTicket, bonusBall)
            }
        )
    }

    @DisplayName("구매한 티켓과 비교하여 일치하는 숫자의 개수를 센다.")
    @Test
    fun match() {
        // given
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(2)
        val lottoNumber3 = LottoNumber.of(3)
        val lottoNumber4 = LottoNumber.of(4)
        val lottoNumber5 = LottoNumber.of(5)
        val lottoNumber6 = LottoNumber.of(6)
        val lottoNumber7 = LottoNumber.of(7)
        val lottoNumber8 = LottoNumber.of(8)
        val lottoNumber9 = LottoNumber.of(9)

        val winningNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6)
        val winningLottoTicket = LottoTicket(winningNumbers)
        val winningLotto = WinningLotto(winningLottoTicket, LottoNumber.of(45))

        val lottoNumbers = listOf(lottoNumber4, lottoNumber5, lottoNumber6, lottoNumber7, lottoNumber8, lottoNumber9)
        val lottoTicket = LottoTicket(lottoNumbers)

        // when
        val matchingCount = winningLotto.match(lottoTicket)

        // then
        assertEquals(matchingCount, 3)
    }

    @DisplayName("보너스 볼을 가지고 있는지 확인한다.")
    @Test
    fun matchBonus() {
        // given
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(2)
        val lottoNumber3 = LottoNumber.of(3)
        val lottoNumber4 = LottoNumber.of(4)
        val lottoNumber5 = LottoNumber.of(5)
        val lottoNumber6 = LottoNumber.of(6)
        val bonusBall = LottoNumber.of(7)

        val winningNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, lottoNumber6)
        val winningLottoTicket = LottoTicket(winningNumbers)
        val winningLotto = WinningLotto(winningLottoTicket, bonusBall)

        val lottoNumbers = listOf(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4, lottoNumber5, bonusBall)
        val lottoTicket = LottoTicket(lottoNumbers)

        // when
        val matchingBonus = winningLotto.matchBonus(lottoTicket)

        // then
        assertEquals(matchingBonus, true)
    }

}
