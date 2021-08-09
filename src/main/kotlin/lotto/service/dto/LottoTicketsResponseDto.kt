package lotto.service.dto

import lotto.domain.ticket.LottoTickets
import java.util.stream.Collectors

class LottoTicketsResponseDto constructor(lottoTicket: LottoTickets) {

    val lottoTickets: List<LottoTicketResponseDto> = lottoTicket.tickets.stream()
        .map { LottoTicketResponseDto(it) }
        .collect(Collectors.toList())

}
