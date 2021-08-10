package lotto.controller

import lotto.service.LottoService
import lotto.service.dto.LottoTicketsResponseDto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private val lottoService: LottoService = LottoService()

    fun run() {
        val money = inputView.inputMoneyToPurchaseLotto()

        val lottoTicketsResponseDto: LottoTicketsResponseDto = lottoService.buyTickets(money)
        outputView.printLottoTickets(lottoTicketsResponseDto)
        outputView.printEmptyLine()
    }

}
