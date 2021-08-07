package lotto.domain.ticket.machine

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTickets

class RandomLottoTicketMachine : LottoTicketMachine {

    override fun buy(purchaseMoney: PurchaseMoney): LottoTickets {
        val numberOfTickets = purchaseMoney.calculateCountToBuy(LottoTicketMachine.TICKET_PRICE)

        return LottoTickets(ArrayList())
    }

}
