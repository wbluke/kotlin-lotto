package lotto.service.dto

import lotto.domain.ticket.matching.LottoRank
import lotto.domain.ticket.matching.MatchingResult
import lotto.utils.format
import java.util.*
import java.util.stream.Collectors

class LottoMatchingResultResponseDto(matchingResult: MatchingResult, private val lottoYield: Double) {

    private val result: MutableMap<LottoRank, Int> = EnumMap(LottoRank::class.java)

    init {
        for (lottoRank in LottoRank.values()) {
            result[lottoRank] = matchingResult.getCountOf(lottoRank)
        }
    }

    fun getResultPairs(): List<Pair<LottoRank, Int>> {
        return enumValues<LottoRank>().reversedArray().toList().stream()
            .filter { it.isNotNone() }
            .map { Pair(it!!, result[it]!!) }
            .collect(Collectors.toList())
    }

    fun getLottoYield(): String {
        return lottoYield.format(2)
    }

}
