package lotto.domain.ticket.machine

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.number.LottoNumber

class RandomLottoTicketMachine : LottoTicketMachine {

    private val lottoNumbers: List<LottoNumber> = LottoNumber.cache.values.toList()

    override fun buy(purchaseMoney: PurchaseMoney): LottoTickets {
        val numberOfTickets = purchaseMoney.calculateCountToBuy(LottoTicketMachine.TICKET_PRICE)

        val tickets: MutableList<LottoTicket> = mutableListOf()
        for (i in 1..numberOfTickets) {
            tickets.add(createLottoTicket())
        }

        return LottoTickets(tickets)
    }

    private fun createLottoTicket(): LottoTicket {
        val selectedNumbers = lottoNumbers.shuffled().subList(0, LottoTicket.SIZE_OF_NUMBERS)
        return LottoTicket(selectedNumbers)
    }

}
