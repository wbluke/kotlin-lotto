package lotto.domain.ticket.matching

import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.winning.WinningLotto
import java.util.*

class MatchingResult private constructor() {

    private val result: MutableMap<LottoRank, Int> = EnumMap(LottoRank::class.java)

    companion object {

        fun of(winningLotto: WinningLotto, lottoTickets: LottoTickets): MatchingResult {
            val matchingResult = MatchingResult()

            for (ticket in lottoTickets.tickets) {
                val matchingCount: Int = winningLotto.match(ticket)
                val matchingBonus: Boolean = winningLotto.matchBonus(ticket)

                val lottoRank = LottoRank.findBy(matchingCount, matchingBonus)
                matchingResult.plusCountBy(lottoRank)
            }

            return matchingResult;
        }

    }

    private fun plusCountBy(lottoRank: LottoRank) {
        result.merge(lottoRank, 1) { a: Int?, b: Int? -> a!! + b!! }
    }

    // TODO: 2021/08/12 test

}
