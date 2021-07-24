package lotto.view

import kotlin.system.exitProcess

class ConsoleInputView : InputView {

    override fun inputMoneyToPurchaseLotto(): Long {
        println("구입금액을 입력해 주세요.")

        val input = readLine()
        try {
            return input!!.toLong()
        } catch (e: NumberFormatException) {
            println("구입금액은 정수로 입력해 주세요.")
            exitProcess(0)
        }
    }

}
