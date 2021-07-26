package lotto.domain.ticket.machine

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTickets

class RandomLottoTicketMachine : LottoTicketMachine {

    // TODO: 2021/07/26 create lotto number pool

    override fun buy(purchaseMoney: PurchaseMoney): LottoTickets {
        val numberOfTickets = purchaseMoney.calculateCountYouCanBuy(LottoTicketMachine.TICKET_PRICE)

        return LottoTickets(ArrayList())
    }

}
