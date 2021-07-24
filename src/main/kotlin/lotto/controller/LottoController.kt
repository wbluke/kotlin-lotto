package lotto.controller

import lotto.domain.money.LottoPurchasedMoney
import lotto.view.InputView

class LottoController(
    private val inputView: InputView
) {

    fun run() {
        val money = inputView.inputMoneyToPurchaseLotto()
        val purchasedMoney = LottoPurchasedMoney(money)
    }

}
