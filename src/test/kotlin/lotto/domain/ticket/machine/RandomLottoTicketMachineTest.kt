package lotto.domain.ticket.machine

import lotto.domain.money.PurchaseMoney
import lotto.domain.ticket.LottoTickets
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class RandomLottoTicketMachineTest {

    @DisplayName("지불한 금액만큼 로또 티켓을 발행한다.")
    @Test
    fun buy() {
        // given
        val purchaseMoney = PurchaseMoney(3000L)
        val randomLottoTicketMachine = RandomLottoTicketMachine()

        // when
        val lottoTickets: LottoTickets = randomLottoTicketMachine.buy(purchaseMoney)

        // then
        assertEquals(lottoTickets.size(), 3)
    }

}
