package lotto.domain.ticket

interface LottoTicketRepository {

    fun save(ticket: LottoTicket)

    fun saveAll(tickets: List<LottoTicket>)

    fun findAll(): List<LottoTicket>

}
