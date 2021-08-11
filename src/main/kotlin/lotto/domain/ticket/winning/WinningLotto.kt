package lotto.domain.ticket.winning

import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.number.LottoNumber

class WinningLotto(winningLottoTicket: LottoTicket, bonusBall: LottoNumber) {

    init {
        if (winningLottoTicket.contains(bonusBall)) {
            throw IllegalArgumentException("보너스 볼은 당첨 번호에 포함되지 않는 숫자여야 합니다.")
        }
    }

}
