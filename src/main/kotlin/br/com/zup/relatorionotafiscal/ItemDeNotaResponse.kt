package br.com.zup.relatorionotafiscal

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal

@Introspected
data class ItemDeNotaResponse(
    val valor: BigDecimal,
    val quantidade: Int
) {

}
