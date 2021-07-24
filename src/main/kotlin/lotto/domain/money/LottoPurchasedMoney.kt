package lotto.domain.money

data class LottoPurchasedMoney(val money: Long) {

    companion object {
        const val MIN_VALUE = 0L
    }

    init {
        if (money <= MIN_VALUE) {
            throw IllegalArgumentException("금액은 ${MIN_VALUE}원 이상이어야 합니다.")
        }
    }

}
