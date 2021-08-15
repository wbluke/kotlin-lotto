package lotto.domain.ticket

class LottoTickets(
    val tickets: List<LottoTicket>
) {

    fun size(): Int {
        return tickets.size
    }

}
