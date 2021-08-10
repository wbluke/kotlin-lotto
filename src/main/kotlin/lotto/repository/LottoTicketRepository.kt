package lotto.repository

import lotto.domain.ticket.LottoTicket

interface LottoTicketRepository {

    fun save(ticket: LottoTicket)

    fun saveAll(tickets: List<LottoTicket>)

}
