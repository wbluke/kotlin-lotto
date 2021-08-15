package lotto.domain.ticket.number

data class LottoNumber private constructor(
    val number: Int
) {

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        val cache: Map<Int, LottoNumber> = createCache()

        private fun createCache(): Map<Int, LottoNumber> {
            return (MIN_NUMBER..MAX_NUMBER).map { it }.associateWith { LottoNumber(it) }
        }

        fun of(number: Int): LottoNumber {
            return cache[number]
                ?: throw IllegalArgumentException("로또 숫자는 ${MIN_NUMBER}에서 $MAX_NUMBER 사이 숫자입니다.")
        }
    }

}
