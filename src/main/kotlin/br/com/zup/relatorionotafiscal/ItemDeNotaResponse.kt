package br.com.zup.relatorionotafiscal

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal

@Introspected
data class ItemDeNotaResponse(
    val valor: BigDecimal,
    val quantidade: Int
) {

    override fun toString(): String {
        return "ItemDeNotaResponse(valor=$valor, quantidade=$quantidade)"
    }
}
