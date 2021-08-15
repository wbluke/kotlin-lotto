package lotto.service.dto

import lotto.domain.ticket.LottoTicket
import java.util.stream.Collectors

class LottoTicketResponseDto constructor(lottoTicket: LottoTicket) {

    val lottoNumbers: List<Int> = lottoTicket.numbers.stream()
        .map { it.number }
        .collect(Collectors.toList())

}
