package lotto.domain.ticket.machine

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTickets

interface LottoTicketMachine {

    companion object {
        const val TICKET_PRICE = 1_000L
    }

    fun buy(purchaseMoney: PurchaseMoney): LottoTickets

}
