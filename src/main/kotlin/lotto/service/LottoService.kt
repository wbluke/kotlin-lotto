package lotto.service

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.machine.LottoTicketMachine
import lotto.domain.ticket.machine.RandomLottoTicketMachine
import lotto.domain.ticket.matching.MatchingResult
import lotto.domain.ticket.number.LottoNumber
import lotto.domain.ticket.winning.WinningLotto
import lotto.repository.LottoTicketRepository
import lotto.service.dto.LottoMatchingResultResponseDto
import lotto.service.dto.LottoTicketsResponseDto

class LottoService(private val lottoTicketRepository: LottoTicketRepository) {

    fun buyTickets(money: Long): LottoTicketsResponseDto {
        val purchasedMoney = PurchaseMoney(money)

        val lottoTicketMachine: LottoTicketMachine = RandomLottoTicketMachine()
        val purchasedTickets: LottoTickets = lottoTicketMachine.buy(purchasedMoney)

        lottoTicketRepository.saveAll(purchasedTickets.tickets)

        return LottoTicketsResponseDto(purchasedTickets)
    }

    fun matchWithWinningLotto(winningNumbers: List<Int>, bonusBall: Int): LottoMatchingResultResponseDto {
        val winningLottoTicket = LottoTicket.ofInt(winningNumbers)
        val winningBonusBall = LottoNumber.of(bonusBall)

        val winningLotto = WinningLotto(winningLottoTicket, winningBonusBall)
        val purchasedTickets = LottoTickets(lottoTicketRepository.findAll())
        val matchingResult = MatchingResult.of(winningLotto, purchasedTickets)

        return LottoMatchingResultResponseDto(matchingResult);
    }

}
