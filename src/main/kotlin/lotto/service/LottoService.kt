package lotto.service

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.machine.LottoTicketMachine
import lotto.domain.ticket.machine.RandomLottoTicketMachine
import lotto.service.dto.LottoTicketsResponseDto

class LottoService {

    fun buyTickets(money: Long): LottoTicketsResponseDto {
        val purchasedMoney = PurchaseMoney(money)

        val lottoTicketMachine: LottoTicketMachine = RandomLottoTicketMachine()
        val purchasedTickets: LottoTickets = lottoTicketMachine.buy(purchasedMoney)

        return LottoTicketsResponseDto(purchasedTickets)
    }

}
