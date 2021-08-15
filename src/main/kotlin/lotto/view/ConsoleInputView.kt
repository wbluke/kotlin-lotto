package lotto.view

import java.util.stream.Collectors
import kotlin.system.exitProcess

class ConsoleInputView : InputView {

    companion object {
        private const val LOTTO_NUMBER_DELIMITER = ","
    }

    override fun inputMoneyToPurchaseLotto(): Long {
        println("구입금액을 입력해 주세요.")

        val input = readLine()
        return catchNumberFormatException(input) { it!!.toLong() }
    }

    override fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val input = readLine()
        return catchNumberFormatException(input) { splitLottoNumbers(it) }
    }

    override fun inputBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")

        val input = readLine()
        return catchNumberFormatException(input) { it!!.toInt() }
    }

    private fun <T> catchNumberFormatException(input: String?, function: (String?) -> T): T {
        try {
            return function.invoke(input)
        } catch (e: NumberFormatException) {
            println("정수로 입력해 주세요.")
            exitProcess(0)
        }
    }

    private fun splitLottoNumbers(input: String?): List<Int> {
        return input!!.split(LOTTO_NUMBER_DELIMITER).stream()
            .map { it.trim() }
            .map { it.toInt() }
            .collect(Collectors.toList())
    }

}
