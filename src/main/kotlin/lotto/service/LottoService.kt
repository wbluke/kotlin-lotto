package lotto.service

import lotto.domain.money.PurchaseMoney
import lotto.domain.money.PurchaseMoneyRepository
import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTicketRepository
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.machine.LottoTicketMachine
import lotto.domain.ticket.machine.RandomLottoTicketMachine
import lotto.domain.ticket.matching.MatchingResult
import lotto.domain.ticket.number.LottoNumber
import lotto.domain.ticket.winning.WinningLotto
import lotto.service.dto.LottoMatchingResultResponseDto
import lotto.service.dto.LottoTicketsResponseDto

class LottoService(
    private val purchaseMoneyRepository: PurchaseMoneyRepository,
    private val lottoTicketRepository: LottoTicketRepository
) {

    fun buyTickets(money: Long): LottoTicketsResponseDto {
        val purchaseMoney = PurchaseMoney(money)
        purchaseMoneyRepository.save(purchaseMoney)

        val lottoTicketMachine: LottoTicketMachine = RandomLottoTicketMachine()
        val purchasedTickets: LottoTickets = lottoTicketMachine.buy(purchaseMoney)

        lottoTicketRepository.saveAll(purchasedTickets.tickets)

        return LottoTicketsResponseDto(purchasedTickets)
    }

    fun matchWithWinningLotto(winningNumbers: List<Int>, bonusBall: Int): LottoMatchingResultResponseDto {
        val winningLottoTicket = LottoTicket.ofInt(winningNumbers)
        val winningBonusBall = LottoNumber.of(bonusBall)

        val winningLotto = WinningLotto(winningLottoTicket, winningBonusBall)
        val purchasedTickets = LottoTickets(lottoTicketRepository.findAll())
        val matchingResult = MatchingResult.of(winningLotto, purchasedTickets)

        val purchaseMoney = purchaseMoneyRepository.find()
        val lottoYield: Double = matchingResult.calculateYield(purchaseMoney)
        return LottoMatchingResultResponseDto(matchingResult, lottoYield);
    }

}
