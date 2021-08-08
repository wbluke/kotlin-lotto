package lotto.controller

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.machine.LottoTicketMachine
import lotto.domain.ticket.machine.RandomLottoTicketMachine
import lotto.view.InputView

class LottoController(
    private val inputView: InputView
) {

    fun run() {
        val money = inputView.inputMoneyToPurchaseLotto()
        val purchasedMoney = PurchaseMoney(money)

        val lottoTicketMachine: LottoTicketMachine = RandomLottoTicketMachine()
        val purchasedTickets: LottoTickets = lottoTicketMachine.buy(purchasedMoney)
    }

}
