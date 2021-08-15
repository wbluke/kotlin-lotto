package lotto.domain.money

interface PurchaseMoneyRepository {

    fun save(purchaseMoney: PurchaseMoney)

    fun find(): PurchaseMoney

}
