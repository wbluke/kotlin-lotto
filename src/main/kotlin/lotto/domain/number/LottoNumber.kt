package lotto.domain.number

data class LottoNumber(
    private val number: Int
) {

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }

    init {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw IllegalArgumentException("로또 숫자는 ${MIN_NUMBER}에서 $MAX_NUMBER 사이 숫자입니다.")
        }
    }

}
