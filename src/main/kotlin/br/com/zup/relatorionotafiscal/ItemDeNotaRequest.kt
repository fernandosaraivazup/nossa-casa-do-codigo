package br.com.zup.relatorionotafiscal

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotNull

@Introspected
data class ItemDeNotaRequest (

    @field:NotNull
    val valor: BigDecimal,

    @field:NotNull
    val quantidade: Int

) {
    fun paraItemDeNote(): ItemDeNota {
        return ItemDeNota(valor, quantidade)
    }
}
