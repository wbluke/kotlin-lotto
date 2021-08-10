package lotto.view

import lotto.service.dto.LottoTicketResponseDto
import lotto.service.dto.LottoTicketsResponseDto

interface OutputView {

    fun printEmptyLine()

    fun printLottoTickets(lottoTicketsResponseDto: LottoTicketsResponseDto)

    fun printLottoTicket(lottoTicketResponseDto: LottoTicketResponseDto)

}
