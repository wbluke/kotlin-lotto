package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInputView
import lotto.view.ConsoleOutputView

fun main() {
    val lottoController = LottoController(ConsoleInputView(), ConsoleOutputView())
    lottoController.run()
}

