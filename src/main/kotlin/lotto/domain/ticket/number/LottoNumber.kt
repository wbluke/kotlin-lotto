package lotto.domain.ticket.number

data class LottoNumber private constructor(
    private val number: Int
) {

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        private val lottoNumberCache: MutableMap<Int, LottoNumber> = mutableMapOf()

        fun of(number: Int): LottoNumber {
            return lottoNumberCache.computeIfAbsent(number) {
                LottoNumber(it)
            }
        }
    }

    init {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw IllegalArgumentException("로또 숫자는 ${MIN_NUMBER}에서 $MAX_NUMBER 사이 숫자입니다.")
        }
    }

}
