package lotto.domain.ticket

import lotto.domain.ticket.number.LottoNumber
import java.util.stream.Collectors

class LottoTicket(
    _numbers: List<LottoNumber>
) {

    val numbers: List<LottoNumber>

    companion object {
        const val SIZE_OF_NUMBERS = 6

        fun ofInt(numbers: List<Int>): LottoTicket {
            val lottoNumbers = numbers.stream()
                .map { LottoNumber.of(it) }
                .collect(Collectors.toList())

            return LottoTicket(lottoNumbers)
        }
    }

    init {
        validateNumbers(_numbers)
        numbers = _numbers.sortedBy { it.number }
    }

    fun contains(bonusBall: LottoNumber): Boolean {
        return numbers.contains(bonusBall)
    }

    private fun validateNumbers(numbers: List<LottoNumber>) {
        if (validateNumberSize(numbers)) {
            throw IllegalArgumentException("로또 한 장의 로또 번호 개수는 ${SIZE_OF_NUMBERS}개입니다.")
        }
        if (validateDuplicateNumber(numbers)) {
            throw IllegalArgumentException("로또 숫자는 중복될 수 없습니다.")
        }
    }

    private fun validateNumberSize(numbers: List<LottoNumber>) =
        numbers.size != SIZE_OF_NUMBERS

    private fun validateDuplicateNumber(numbers: List<LottoNumber>): Boolean {
        return numbers.stream()
            .collect(Collectors.toSet())
            .size != SIZE_OF_NUMBERS
    }

}
