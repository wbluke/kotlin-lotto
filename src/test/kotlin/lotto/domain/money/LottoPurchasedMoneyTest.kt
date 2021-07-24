package lotto.domain.money

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class LottoPurchasedMoneyTest {

    @DisplayName("로또 구입 금액은 0원 이상이다.")
    @Test
    internal fun create() {
        // given
        val money = 0L

        // when // then
        assertFailsWith<IllegalArgumentException>(
            message = "No exception found",
            block = {
                LottoPurchasedMoney(money)
            }
        )
    }

}
