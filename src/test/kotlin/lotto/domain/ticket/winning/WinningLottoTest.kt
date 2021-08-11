package lotto.domain.ticket.winning

import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.number.LottoNumber
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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

}
