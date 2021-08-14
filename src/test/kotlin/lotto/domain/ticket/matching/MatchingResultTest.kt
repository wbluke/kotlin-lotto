package lotto.domain.ticket.matching

import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.number.LottoNumber
import lotto.domain.ticket.winning.WinningLotto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MatchingResultTest {

    @DisplayName("당첨번호를 기반으로 로또 티켓들의 당첨결과를 생성한다.")
    @Test
    fun create() {
        // given
        val number1 = LottoNumber.of(1)
        val number2 = LottoNumber.of(2)
        val number3 = LottoNumber.of(3)
        val number4 = LottoNumber.of(4)
        val number5 = LottoNumber.of(5)
        val number6 = LottoNumber.of(6)
        val number7 = LottoNumber.of(7)
        val number8 = LottoNumber.of(8)
        val number9 = LottoNumber.of(9)
        val number10 = LottoNumber.of(10)

        val bonusBall = LottoNumber.of(45)

        val winningLottoTicket = LottoTicket(listOf(number1, number2, number3, number4, number5, number6))
        val winningLotto = WinningLotto(winningLottoTicket, bonusBall)

        val firstTicket = LottoTicket(listOf(number1, number2, number3, number4, number5, number6))
        val secondTicket = LottoTicket(listOf(number2, number3, number4, number5, number6, bonusBall))
        val thirdTicket = LottoTicket(listOf(number2, number3, number4, number5, number6, number8))
        val fourthTicket = LottoTicket(listOf(number3, number4, number5, number6, number7, number8))
        val fifthTicket = LottoTicket(listOf(number4, number5, number6, number7, number8, number9))
        val noneTicket = LottoTicket(listOf(number5, number6, number7, number8, number9, number10))
        val lottoTickets = LottoTickets(
            listOf(firstTicket, secondTicket, thirdTicket, fourthTicket, fifthTicket, noneTicket)
        )

        // when
        val matchingResult = MatchingResult.of(winningLotto, lottoTickets)

        // then
        assertEquals(matchingResult.getCountOf(LottoRank.FIRST), 1)
        assertEquals(matchingResult.getCountOf(LottoRank.SECOND), 1)
        assertEquals(matchingResult.getCountOf(LottoRank.THIRD), 1)
        assertEquals(matchingResult.getCountOf(LottoRank.FOURTH), 1)
        assertEquals(matchingResult.getCountOf(LottoRank.FIFTH), 1)
        assertEquals(matchingResult.getCountOf(LottoRank.NONE), 1)
    }

}
