package lotto.domain.ticket.matching

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

internal class LottoRankTest {

    @DisplayName("5개 숫자 일치, 보너스 볼 일치하면 2등")
    @Test
    fun findBy1() {
        // given
        val matchingCount = 5
        val matchingBonus = true

        // when
        val lottoRank = LottoRank.findBy(matchingCount, matchingBonus)

        // then
        assertEquals(lottoRank, LottoRank.SECOND)
    }

    @DisplayName("5개 숫자 일치, 보너스 볼 일치하지 않으면 3등")
    @Test
    fun findBy2() {
        // given
        val matchingCount = 5
        val matchingBonus = false

        // when
        val lottoRank = LottoRank.findBy(matchingCount, matchingBonus)

        // then
        assertEquals(lottoRank, LottoRank.THIRD)
    }

    @DisplayName("1등, 4등, 5등은 맞춘 숫자에 따라 정해진다.")
    @ParameterizedTest
    @CsvSource("6,true,FIRST", "6,false,FIRST", "4,true,FOURTH", "4,false,FOURTH", "3,true,FIFTH", "3,false,FIFTH")
    fun findBy3(matchingCount: Int, matchingBonus: Boolean, expectedLottoRank: LottoRank) { // given
        // when
        val lottoRank = LottoRank.findBy(matchingCount, matchingBonus)

        // then
        assertEquals(lottoRank, expectedLottoRank)
    }

    @DisplayName("맞는 숫자가 2개 이하면 당첨되지 않는다.")
    @ParameterizedTest
    @CsvSource("2,true,NONE", "2,false,NONE", "1,true,NONE", "1,false,NONE", "0,true,NONE", "0,false,NONE")
    fun findBy4(matchingCount: Int, matchingBonus: Boolean, expectedLottoRank: LottoRank) { // given
        // when
        val lottoRank = LottoRank.findBy(matchingCount, matchingBonus)

        // then
        assertEquals(lottoRank, expectedLottoRank)
    }

}
