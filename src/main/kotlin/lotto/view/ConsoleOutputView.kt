package lotto.view

import lotto.service.dto.LottoTicketResponseDto
import lotto.service.dto.LottoTicketsResponseDto

class ConsoleOutputView : OutputView {

    override fun printLottoTickets(lottoTicketsResponseDto: LottoTicketsResponseDto) {
        for (lottoTicketResponseDto in lottoTicketsResponseDto.lottoTickets) {
            printLottoTicket(lottoTicketResponseDto)
        }
    }

    override fun printLottoTicket(lottoTicketResponseDto: LottoTicketResponseDto) {
        val lottoNumbers = lottoTicketResponseDto.lottoNumbers.joinToString(
            separator = ", ",
            prefix = "[",
            postfix = "]"
        )

        println(lottoNumbers)
    }

}
