package lotto

import lotto.controller.LottoController
import lotto.view.ConsoleInputView

fun main() {
    val lottoController = LottoController(ConsoleInputView())
    lottoController.run()
}

