package lotto.domain.money

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class PurchaseMoneyTest {

    @DisplayName("로또 구입 금액은 0원 이상이다.")
    @Test
    fun create() {
        // given
        val money = 0L

        // when // then
        assertFailsWith<IllegalArgumentException>(
            block = {
                PurchaseMoney(money)
            }
        )
    }

    @DisplayName("기준 금액으로 몇 개의 수량을 살 수 있는지 계산한다.")
    @Test
    internal fun calculateCountYouCanBuy() {
        // given
        val baseMoney = 1_000L
        val money = 14_000L

        val purchaseMoney = PurchaseMoney(money)

        // when
        val result = purchaseMoney.calculateCountToBuy(baseMoney)

        // then
        assertEquals(result, 14)
    }

}
