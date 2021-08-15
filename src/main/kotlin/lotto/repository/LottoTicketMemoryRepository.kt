package lotto.repository

import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTicketRepository

class LottoTicketMemoryRepository : LottoTicketRepository {

    private val lottoTickets: MutableList<LottoTicket> = mutableListOf()

    override fun save(ticket: LottoTicket) {
        lottoTickets.add(ticket)
    }

    override fun saveAll(tickets: List<LottoTicket>) {
        lottoTickets.addAll(tickets)
    }

    override fun findAll(): List<LottoTicket> {
        return lottoTickets
    }

}
