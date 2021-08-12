package lotto.domain.ticket.matching

enum class LottoRank(val matchingCount: Int, val prize: Long) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {

        fun findBy(matchingCount: Int, matchingBonus: Boolean): LottoRank =
            when (matchingCount) {
                SECOND.matchingCount -> if (matchingBonus) SECOND else THIRD
                FIRST.matchingCount -> FIRST
                FOURTH.matchingCount -> FOURTH
                FIFTH.matchingCount -> FIFTH
                else -> NONE
            }

    }

    // TODO: 2021/08/12 test

}
