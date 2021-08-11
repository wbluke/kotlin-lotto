package lotto.view

interface InputView {

    fun inputMoneyToPurchaseLotto(): Long

    fun inputWinningNumbers(): List<Int>

    fun inputBonusBall(): Int

}
