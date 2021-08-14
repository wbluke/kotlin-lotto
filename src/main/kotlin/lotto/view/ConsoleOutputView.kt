package lotto.view

import lotto.domain.ticket.matching.LottoRank
import lotto.service.dto.LottoMatchingResultResponseDto
import lotto.service.dto.LottoTicketResponseDto
import lotto.service.dto.LottoTicketsResponseDto

class ConsoleOutputView : OutputView {

    override fun printEmptyLine() {
        println()
    }

    override fun printLottoTickets(lottoTicketsResponseDto: LottoTicketsResponseDto) {
        println("${lottoTicketsResponseDto.size()}개를 구매했습니다.")
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

    override fun printMatchingResult(lottoMatchingResultResponseDto: LottoMatchingResultResponseDto) {
        println("당첨 통계")
        println("------------------------------------")
        for (resultPair in lottoMatchingResultResponseDto.getResultPairs()) {
            println("${getMatchingMessage(resultPair.first)} - ${resultPair.second}개")
        }
    }

    private fun getMatchingMessage(lottoRank: LottoRank): String {
        if (lottoRank.isSecond()) {
            return "${lottoRank.matchingCount}개 일치, 보너스 볼 일치 (${lottoRank.prize}원)"
        }

        return "${lottoRank.matchingCount}개 일치 (${lottoRank.prize}원)"
    }

}
