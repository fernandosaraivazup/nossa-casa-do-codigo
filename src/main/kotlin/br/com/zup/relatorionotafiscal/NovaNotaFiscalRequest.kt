package br.com.zup.relatorionotafiscal

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class NovaNotaFiscalRequest(
    @field:NotBlank
    val numero: String,

    @field:NotBlank
    val serie: String,

    @field:NotNull
    val data: LocalDate,

    @field:Size(min = 1)
    val itens: List<ItemDeNotaRequest>
) {
    fun paraNotaFiscal(): NotaFiscal {
        return NotaFiscal(numero, serie, data, itens.map { itens -> ItemDeNota(itens.valor, itens.quantidade) })
    }
}
