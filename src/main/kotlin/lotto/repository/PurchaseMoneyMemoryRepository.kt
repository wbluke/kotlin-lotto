package lotto.repository

import lotto.domain.money.PurchaseMoney
import lotto.domain.money.PurchaseMoneyRepository

class PurchaseMoneyMemoryRepository : PurchaseMoneyRepository {

    private var money: PurchaseMoney? = null

    override fun save(purchaseMoney: PurchaseMoney) {
        money = purchaseMoney
    }

    override fun find(): PurchaseMoney {
        return money!!
    }

}
